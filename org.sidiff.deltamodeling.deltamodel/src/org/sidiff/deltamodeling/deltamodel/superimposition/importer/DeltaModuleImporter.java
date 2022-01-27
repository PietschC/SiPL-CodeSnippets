package org.sidiff.deltamodeling.deltamodel.superimposition.importer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.deltamodeling.deltamodel.DeltaModule;
import org.sidiff.deltamodeling.deltamodel.DeltaModuleSet;
import org.sidiff.deltamodeling.deltamodel.Relation;
import org.sidiff.deltamodeling.deltamodel.superimposition.filter.ExtendableEMFImporterFilter;
import org.sidiff.deltamodeling.deltamodel.superimposition.util.AnnotationUtil;
import org.sidiff.difference.asymmetric.AttributeDependency;
import org.sidiff.difference.asymmetric.Dependency;
import org.sidiff.difference.asymmetric.DependencyContainer;
import org.sidiff.difference.asymmetric.EdgeDependency;
import org.sidiff.difference.asymmetric.MultiParameterBinding;
import org.sidiff.difference.asymmetric.NodeDependency;
import org.sidiff.difference.asymmetric.ObjectParameterBinding;
import org.sidiff.difference.asymmetric.OperationInvocation;
import org.sidiff.difference.asymmetric.ParameterBinding;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.EObjectSet;
import org.sidiff.difference.symmetric.EditRuleMatch;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SemanticChangeSet;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.symmetric.SymmetricFactory;
import org.sidiff.entities.Annotation;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Element;
import org.sidiff.entities.Reference;
import org.sidiff.entities.importer.ImportFailedException;
import org.sidiff.entities.importer.filter.IImporterFilter;
import org.sidiff.entities.importer.uuid.IImporterUuidResolver;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.matching.model.Matching;
import org.sidiff.superimposition.SuperimposedElement;
import org.sidiff.superimposition.SuperimposedModel;
import org.sidiff.superimposition.importer.SuperimpositionModelImporter;

/**
 * 
 * @author cpietsch
 *
 */
public class DeltaModuleImporter extends SuperimpositionModelImporter {
	
	private Set<EObject> mandatoryEObjects;

	private Annotation annotation_remove;
	private Annotation annotation_add;
	private Annotation annotation_preserve;

	/**
	 * Constructor
	 */
	public DeltaModuleImporter(Set<String> documentTypes) {
		super();
		((ExtendableEMFImporterFilter)this.getFilter()).init(Collections.unmodifiableSet(documentTypes));
	}	
	
	public void init(DeltaModuleSet deltaModuleSet) {
		super.init(deltaModuleSet.getSuperimposedModel());
	}

	public void removeAllAnnotated(DeltaModule deltaModule) {
		
		// get all relations of the delta module to be deleted
		//
		Set<Relation> relations = new HashSet<>();

		relations.addAll(deltaModule.getOutgoingConflictRelations());
		relations.addAll(deltaModule.getIncomingConflictRelations());
		relations.addAll(deltaModule.getOutgoingDependencyRelations());
		relations.addAll(deltaModule.getIncomingDependencyRelations());
		relations.addAll(deltaModule.getDuplicateRelations());
		relations.addAll(deltaModule.getOutgoingTransientEffectRelations());
		relations.addAll(deltaModule.getIncomingTransientEffectRelations());

		// delete all relations from any other feature that references it
		//
		relations.forEach(relation -> EcoreUtil.delete(relation, true));
		
		// init annotations
		//
		initAnnotations(deltaModule);
		
		// delete all annotations and elements related to the delta module
		//
		getSuperimposedModel().getAnnotations().stream()
				.filter(annotation -> annotation_remove != null && annotation.getBody().equals(annotation_remove.getBody())
						|| annotation_add != null && annotation.getBody().equals(annotation_add.getBody())
						|| annotation_preserve != null && annotation.getBody().equals(annotation_preserve.getBody()))
				.collect(Collectors.toSet()).forEach(super::removeAllAnnotated);
		
	}
	
	public void removeEObjects(Collection<EObject> eObjects) {
		for(EObject eObject : eObjects) {
			for (Iterator<EObject> iterator = eObject.eAllContents(); iterator.hasNext();) {
				EObject next = iterator.next();
				removeEObject(next);
			}
			removeEObject(eObject);
		}
	}
		
	
	public void removeEObject(EObject eObject) {

		SuperimposedElement superimposedElement = getObjectIndex().get(eObject);
		if (superimposedElement != null) {
			if (superimposedElement.getObjects().contains(eObject)) {
				superimposedElement.getObjects().remove(eObject);
			}

			if (superimposedElement.getObject().equals(eObject)) {
				superimposedElement.setObject(superimposedElement.getObjects().iterator().next());
			}

			superimposedElement.getObjectAnnotations().removeKey(eObject);

			getObjectIndex().remove(eObject);
		}
		
	}

	/**
	 * Imports model elements referenced by a given {@link DeltaModule} into the
	 * {@link SuperimposedModel}
	 * 
	 * @param deltaModule
	 *            the {@link DeltaModule} to be imported
	 * @param elementBindings
	 *            predefined binding of {@link EObject}s to existing
	 *            {@link SuperimposedElement}s
	 * @param DeltaModule 
	 *            
	 * @throws ImportFailedException
	 */
	public void importDeltaModule(DeltaModule deltaModule, Map<EObject,SuperimposedElement> elementBindings) throws ImportFailedException {
		
		// init annotations
		//
		initAnnotations(deltaModule);
		
		// element bindings
		//
		getObjectIndex().putAll(elementBindings);
		
		// init UuidResolver with already used UUIDs		
		//
		getUuidResolver().init(Collections.singleton(getUuidIndex()));
		
		// init mandatory eObjects
		//
		mandatoryEObjects = new HashSet<>();

		for (SemanticChangeSet scs : deltaModule.getDelta().getSymmetricDifference().getChangeSets()) {
			EditRuleMatch erMatch = scs.getEditRuleMatch();
			for (EObjectSet eObjectSet : erMatch.getNodeOccurrencesA().values()) {
				mandatoryEObjects.addAll(eObjectSet.getElements());
			}
			for (EObjectSet eObjectSet : erMatch.getNodeOccurrencesB().values()) {
				mandatoryEObjects.addAll(eObjectSet.getElements());
			}
		}
		
		// symmetric difference
		//
		importSymmetricDifference(deltaModule.getDelta().getSymmetricDifference());

		// operation invocations
		//
		for (OperationInvocation opInv : deltaModule.getDelta().getOperationInvocations()) {
			importOperationInvocation(opInv);
		}

		// dependencies
		//
		for (DependencyContainer depCon : deltaModule.getDelta().getDepContainers()) {
			importDependencyContainer(depCon);
		}

		// annotations
		//
		if (!annotation_preserve.getEntities().isEmpty()) {
			getSuperimposedModel().getAnnotations().add(annotation_preserve);
		}

		if (!annotation_remove.getEntities().isEmpty()) {
			getSuperimposedModel().getAnnotations().add(annotation_remove);
		}

		if (!annotation_add.getEntities().isEmpty()) {
			getSuperimposedModel().getAnnotations().add(annotation_add);
		}

		cleanUp(annotation_preserve, annotation_remove, annotation_add);
	}

	private void importSymmetricDifference(SymmetricDifference symmetricDifference) throws ImportFailedException {
		// matching
		//
		importMatching(symmetricDifference.getMatching());

		// changes
		//
		for (SemanticChangeSet scs : symmetricDifference.getChangeSets()) {
			for (Change c : scs.getChanges()) {
				importChange(c);
			}
			importEditRuleMatch(scs.getEditRuleMatch());
		}
	}

	private void importMatching(Matching matching) throws ImportFailedException {
		// Correspondence
		//
		Map<EObject, EObject> correspondences = new HashMap<>();
		for (Correspondence c : new ArrayList<>(matching.getCorrespondences())) {
			EObject matchedA = c.getMatchedA();
			EObject matchedB = c.getMatchedB();
			
			if (mandatoryEObjects.contains(matchedA) && mandatoryEObjects.contains(matchedB)) {
				correspondences.put(matchedA, matchedB);
				SuperimposedElement element = importEObjects(Arrays.asList(matchedA, matchedB), annotation_preserve);
				c.setMatchedA(element);
				c.setMatchedB(element);

				for (EAttribute eAttribute : matchedA.eClass().getEAllAttributes()) {
					if (getFilter().isConsidered(eAttribute, matchedA)
							&& getFilter().isConsidered(eAttribute, matchedB)) {
						Object objectA = matchedA.eGet(eAttribute);
						Object objectB = matchedB.eGet(eAttribute);

						if (objectA == null && objectB == null || objectA != null && objectB != null && objectA.equals(objectB)) {
							Attribute attribute = this.importEAttribute(eAttribute, matchedA);
							attribute.getAnnotations().add(annotation_preserve);
						}
					}
				}
				for (EReference eReference : matchedA.eClass().getEAllReferences()) {
					if (getFilter().isConsidered(eReference, matchedA)
							&& getFilter().isConsidered(eReference, matchedB)) {
						List<EObject> tgtsA = EMFUtil.getReferenceTargets(matchedA, eReference);
						List<EObject> tgtsB = EMFUtil.getReferenceTargets(matchedB, eReference);
						if (!tgtsA.isEmpty() && !tgtsB.isEmpty()) {
							for (EObject eObjectA : tgtsA) {
								if (correspondences.get(eObjectA) != null && mandatoryEObjects.contains(eObjectA)) {
									Reference reference = importEReference(eReference, matchedA, eObjectA);
									reference.getAnnotations().add(annotation_preserve);
								}
							}
						}
					}
				}
			} else {
				String xmiId_matchedA = EMFUtil.getXmiId(matchedA);
				String xmiId_matchedB = EMFUtil.getXmiId(matchedB);
				if(xmiId_matchedA != null && !xmiId_matchedA.equals(xmiId_matchedB)) {
					EMFUtil.setXmiId(matchedB, xmiId_matchedA);
				}
				EcoreUtil.delete(c);
			}
		}

		// Unmatched A
		//
		Set<EObject> unmatchedA = new HashSet<>(matching.getUnmatchedA());
		for (EObject eObject : unmatchedA) {
			if (mandatoryEObjects.contains(eObject)) {
				Element element = importEObject(eObject);
				matching.getUnmatchedA().add(element);
			}
			matching.getUnmatchedA().remove(eObject);
		}

		// Unmatched B
		//
		Set<EObject> unmatchedB = new HashSet<>(matching.getUnmatchedB());
		for (EObject eObject : unmatchedB) {
			if (mandatoryEObjects.contains(eObject)) {
				Element element = importEObject(eObject);
				matching.getUnmatchedB().add(element);
			}
			matching.getUnmatchedB().remove(eObject);
		}
	}

	private void importChange(Change change) throws ImportFailedException {
		if (change instanceof RemoveObject) {
			importRemoveObject((RemoveObject) change);
		} else if (change instanceof RemoveReference) {
			importRemoveReference((RemoveReference) change);
		} else if (change instanceof AddObject) {
			importAddObject((AddObject) change);
		} else if (change instanceof AddReference) {
			importAddReference((AddReference) change);
		} else if (change instanceof AttributeValueChange) {
			importAttributeValueChange((AttributeValueChange)change);
		}
	}

	private void importRemoveObject(RemoveObject removeObject) throws ImportFailedException {
		EObject eObject = removeObject.getObj();

		Element elementA = importEObject(eObject, annotation_remove);
		removeObject.setObj(elementA);

		for (EAttribute eAttribute : eObject.eClass().getEAllAttributes()) {
			if (getFilter().isConsidered(eAttribute, eObject)) {
				Attribute attribute = importEAttribute(eAttribute, eObject);
				attribute.getAnnotations().add(annotation_remove);
			}
		}
	}

	private void importRemoveReference(RemoveReference removeReference) throws ImportFailedException {
		if (getFilter().isConsidered(removeReference.getType(), removeReference.getSrc())) {
			Reference referenceA = importEReference(removeReference.getType(), removeReference.getSrc(),
					removeReference.getTgt());
			removeReference.setSrc(referenceA.getSource());
			removeReference.setTgt(referenceA.getTarget());

			referenceA.getAnnotations().add(annotation_remove);
		}
	}

	private void importAddObject(AddObject addObject) throws ImportFailedException {
		EObject eObject = addObject.getObj();

		Element elementB = importEObject(eObject, annotation_add);
		addObject.setObj(elementB);

		for (EAttribute eAttribute : eObject.eClass().getEAllAttributes()) {
			if (getFilter().isConsidered(eAttribute, eObject)) {
				Attribute attribute = importEAttribute(eAttribute, eObject);
				attribute.getAnnotations().add(annotation_add);
			}
		}
	}

	private void importAddReference(AddReference addReference) throws ImportFailedException {
		EObject src = addReference.getSrc();
		EObject tgt = addReference.getTgt();

		if (getFilter().isConsidered(addReference.getType(), src)) {
			Reference referenceB = importEReference(addReference.getType(), src, tgt);

			Element elementTgt = referenceB.getTarget();
			if (elementTgt.isExternal()
					&& !src.eResource().equals(elementTgt.getObject().eResource())) {
				for (EAttribute eAttribute : tgt.eClass().getEAllAttributes()) {
					if (getFilter().isConsidered(eAttribute, tgt)) {
						importEAttribute(eAttribute, tgt);
					}
				}
			}

			addReference.setSrc(referenceB.getSource());
			addReference.setTgt(referenceB.getTarget());

			referenceB.getAnnotations().add(annotation_add);
		}
	}

	private void importAttributeValueChange(AttributeValueChange attributeValueChange) throws ImportFailedException {
		Element elementA = importEObject(attributeValueChange.getObjA());
		Attribute attributeA = this.importEAttribute(attributeValueChange.getType(),
				attributeValueChange.getObjA());
		attributeA.getAnnotations().add(annotation_remove);

		Element elementB = importEObject(attributeValueChange.getObjB());
		Attribute attributeB = this.importEAttribute(attributeValueChange.getType(),
				attributeValueChange.getObjB());
		attributeB.getAnnotations().add(annotation_add);

		assert elementA.equals(elementB) : "should be the same";

		attributeValueChange.setObjA(elementA);
		attributeValueChange.setObjB(elementB);
	}

	private void importEditRuleMatch(EditRuleMatch editRuleMatch) throws ImportFailedException {

		// node occurrences in A
		//
		for (String nodeOccurrenceA_key : editRuleMatch.getNodeOccurrencesA().keySet()) {
			EObjectSet eObjectSet = SymmetricFactory.eINSTANCE.createEObjectSet();
			for (EObject srcObject : editRuleMatch.getNodeOccurrencesA().get(nodeOccurrenceA_key).getElements()) {
				Element elementA = importEObject(srcObject);
				eObjectSet.addElement(elementA);
			}
			editRuleMatch.getNodeOccurrencesA().put(nodeOccurrenceA_key, eObjectSet);
		}

		// node occurrences in B
		//
		for (String nodeOccurrenceB_key : editRuleMatch.getNodeOccurrencesB().keySet()) {
			EObjectSet eObjectSet = SymmetricFactory.eINSTANCE.createEObjectSet();
			for (EObject srcObject : editRuleMatch.getNodeOccurrencesB().get(nodeOccurrenceB_key).getElements()) {
				Element elementB = importEObject(srcObject);
				eObjectSet.addElement(elementB);
			}
			editRuleMatch.getNodeOccurrencesB().put(nodeOccurrenceB_key, eObjectSet);
		}
	}

	private void importOperationInvocation(OperationInvocation operationInvocation) throws ImportFailedException {
		for (ParameterBinding binding : operationInvocation.getParameterBindings()) {
			if (binding instanceof ObjectParameterBinding) {
				importObjectParameterBinding((ObjectParameterBinding) binding);
			} else if (binding instanceof MultiParameterBinding) {
				MultiParameterBinding multiParameter = (MultiParameterBinding) binding;
				for (ParameterBinding nestedBinding : multiParameter.getParameterBindings()) {
					if (nestedBinding instanceof ObjectParameterBinding) {
						importObjectParameterBinding((ObjectParameterBinding) nestedBinding);
					}
				}
			}
		}
	}

	private void importObjectParameterBinding(ObjectParameterBinding objectParameterBinding)
			throws ImportFailedException {

		if (objectParameterBinding.getActualA() != null) {
			Element elementA = importEObject(objectParameterBinding.getActualA());
			objectParameterBinding.setActualA(elementA);
		}

		if (objectParameterBinding.getActualB() != null) {
			Element elementB = importEObject(objectParameterBinding.getActualB());
			objectParameterBinding.setActualB(elementB);
		}
	}

	private void importDependencyContainer(DependencyContainer dependencyContainer) throws ImportFailedException {
		for (Dependency dependency : dependencyContainer.getDependencies()) {
			if (dependency instanceof NodeDependency) {
				importNodeDependency((NodeDependency) dependency);
			} else if (dependency instanceof EdgeDependency) {
				importEdgeDependency((EdgeDependency) dependency);
			} else if (dependency instanceof AttributeDependency) {
				importAttributeDependency((AttributeDependency) dependency);
			}
		}
	}

	private void importNodeDependency(NodeDependency nodeDependency) throws ImportFailedException {
		Element element = importEObject(nodeDependency.getObject());
		nodeDependency.setObject(element);
	}

	private void importEdgeDependency(EdgeDependency edgeDependency) throws ImportFailedException {
		Reference reference = importEReference(edgeDependency.getType(),
				edgeDependency.getSrcObject(), edgeDependency.getTgtObject());
		edgeDependency.setSrcObject(reference.getSource());
		edgeDependency.setTgtObject(reference.getTarget());
	}

	private void importAttributeDependency(AttributeDependency attributeDependency) throws ImportFailedException {
		Attribute attribute = importEAttribute(attributeDependency.getType(), attributeDependency.getObject());
		attributeDependency.setObject(attribute.eContainer());
	}


	@Override
	protected SuperimposedElement doImportEObject(EObject eObject) throws ImportFailedException {
		SuperimposedElement element = super.doImportEObject(eObject);
		if(!element.isExternal()) {
			EMFUtil.setXmiId(eObject, element.getUuid());
		}
		return element;
	}
	
	@Override
	protected boolean updateElement(SuperimposedElement element, EObject eObject) throws ImportFailedException {
		boolean update =  super.updateElement(element, eObject);
		if(!element.isExternal() && !EMFUtil.getXmiId(eObject).equals(element.getUuid())) {
			EMFUtil.setXmiId(eObject, element.getUuid());
		}
		
		return update;
	}
	
	private void initAnnotations(DeltaModule deltaModule) {
		annotation_remove = AnnotationUtil.initDeleteAnnotation(deltaModule);
		annotation_add = AnnotationUtil.initCreateAnnotation(deltaModule);
		annotation_preserve = AnnotationUtil.initPreserveAnnotation(deltaModule);
	}
	
	@Override
	protected IImporterFilter createFilter() {
		return new ExtendableEMFImporterFilter();
	}
	
	@Override
	protected IImporterUuidResolver createUuidResolver() {
		return new XmiIDImporterUuidResolver();
	}
}
