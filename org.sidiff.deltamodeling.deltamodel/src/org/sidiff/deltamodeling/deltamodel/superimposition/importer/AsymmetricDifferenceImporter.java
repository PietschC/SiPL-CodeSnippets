package org.sidiff.deltamodeling.deltamodel.superimposition.importer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.difference.asymmetric.AsymmetricDifference;
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
import org.sidiff.entities.Entity;
import org.sidiff.entities.Reference;
import org.sidiff.entities.importer.ImportFailedException;
import org.sidiff.entities.util.EntitiesUtil;
import org.sidiff.formula.util.FormulaUtil;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.matching.model.Matching;
import org.sidiff.superimposition.SuperimposedElement;
import org.sidiff.superimposition.importer.SuperimpositionModelImporter;

/**
 * 
 * @author cpietsch
 * @deprecated use {@link DeltaModuleImporter} instead
 */
public class AsymmetricDifferenceImporter extends SuperimpositionModelImporter {
	
	private Annotation annotation_rem;
	
	private Annotation annotation_add;
	
	private Annotation annotation_c;
	
	private Set<EObject> mandatoryEObjects;
	
	/**
	 * 
	 * @param asymmetricDifference
	 * @param eObject2element
	 * @throws ImportFailedException
	 */
	public void importAsymmetricDifference(AsymmetricDifference asymmetricDifference, String name, Map<EObject, SuperimposedElement> eObject2element) throws ImportFailedException{
						
		getObjectIndex().putAll(eObject2element);
		
		mandatoryEObjects = new HashSet<EObject>();
		for(SemanticChangeSet scs : asymmetricDifference.getSymmetricDifference().getChangeSets()) {
			EditRuleMatch erMatch = scs.getEditRuleMatch();
			for(EObjectSet eObjectSet : erMatch.getNodeOccurrencesA().values()) {
					mandatoryEObjects.addAll(eObjectSet.getElements());
			}
			for(EObjectSet eObjectSet : erMatch.getNodeOccurrencesB().values()) {
				mandatoryEObjects.addAll(eObjectSet.getElements());
			}
		}

		annotation_rem = EntitiesUtil.createConditionAnnotation(FormulaUtil.createNot(FormulaUtil.createVariable(name)));
		getSuperimposedModel().getAnnotations().add(annotation_rem);

		annotation_add = EntitiesUtil.createConditionAnnotation(FormulaUtil.createVariable(name));
		getSuperimposedModel().getAnnotations().add(annotation_add);

		annotation_c = EntitiesUtil.createConditionAnnotation(
				FormulaUtil.createOr(
						FormulaUtil.createNot(FormulaUtil.createVariable(name)),
						FormulaUtil.createVariable(name)));
		getSuperimposedModel().getAnnotations().add(annotation_c);
		
		importSymmetricDifference(asymmetricDifference.getSymmetricDifference());
		
		for(OperationInvocation opInv : asymmetricDifference.getOperationInvocations()){
			importOperationInvocation(opInv);
		}
		
		for(DependencyContainer depCon : asymmetricDifference.getDepContainers()){
			importDependencyContainer(depCon);
		}
	}

	/**
	 * 
	 * @param operationInvocation
	 * @throws ImportFailedException 
	 */
	private void importOperationInvocation(OperationInvocation operationInvocation) throws ImportFailedException{
		for(ParameterBinding binding : operationInvocation.getParameterBindings()){
			
			if(binding instanceof ObjectParameterBinding){
				
				ObjectParameterBinding opb = (ObjectParameterBinding) binding;
				importObjectParameterBinding(opb);
				
			}else if(binding instanceof MultiParameterBinding){
				
				MultiParameterBinding mpb = (MultiParameterBinding) binding;
				
				for(ParameterBinding binding_of_mpb : mpb.getParameterBindings()){
					
					if(binding_of_mpb instanceof ObjectParameterBinding){
						
						ObjectParameterBinding opb = (ObjectParameterBinding) binding_of_mpb;
						importObjectParameterBinding(opb);
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * @param objectParameterBinding
	 * @throws ImportFailedException 
	 */
	private void importObjectParameterBinding(ObjectParameterBinding objectParameterBinding) throws ImportFailedException{
		
		if(objectParameterBinding.getActualA()!= null){
			Element elementA = importEObject(objectParameterBinding.getActualA());
			objectParameterBinding.setActualA(elementA);
		}
		
		if(objectParameterBinding.getActualB()!=null){
			Element elementB= importEObject(objectParameterBinding.getActualB());
			objectParameterBinding.setActualB(elementB);
		}
	}
	
	/**
	 * 
	 * @param dependencyContainer
	 * @throws ImportFailedException
	 */
	private void importDependencyContainer(DependencyContainer dependencyContainer) throws ImportFailedException{
		for(Dependency dependency : dependencyContainer.getDependencies()){
			
			// NodeDependency
			if(dependency instanceof NodeDependency){
				
				NodeDependency nodeDependency = (NodeDependency) dependency;
				Element element = importEObject(nodeDependency.getObject());
				nodeDependency.setObject(element);
				
			// EdgeDependency
			}else if(dependency instanceof EdgeDependency){
				
				EdgeDependency edgeDependency = (EdgeDependency) dependency;
				Reference reference = importEReference(edgeDependency.getType(), edgeDependency.getSrcObject(), edgeDependency.getTgtObject());
				edgeDependency.setSrcObject(reference.getSource());
				edgeDependency.setTgtObject(reference.getTarget());
				
			// AttributeDependency
			}else if(dependency instanceof AttributeDependency){
				
				AttributeDependency attributeDependency = (AttributeDependency) dependency;
				Attribute attribute = importEAttribute(attributeDependency.getType(), attributeDependency.getObject());
				attributeDependency.setObject(attribute.eContainer());
			}
		}
	}
	
	/**
	 * 
	 * @param symmetricDifference
	 * @throws ImportFailedException
	 */
	private void importSymmetricDifference(SymmetricDifference symmetricDifference) throws ImportFailedException{
		importMatching(symmetricDifference.getMatching());
		for(SemanticChangeSet scs : symmetricDifference.getChangeSets()){
			for(Change c : scs.getChanges()){
				this.importChange(c);
			}
			this.importEditRuleMatch(scs.getEditRuleMatch());		
		}
	}
	
	/**
	 * 
	 * @param matching
	 * @throws ImportFailedException
	 */
	@SuppressWarnings("unchecked")
	private void importMatching(Matching matching) throws ImportFailedException{
		// Correspondence
		Map<EObject, EObject> correspondences = new HashMap<EObject, EObject>();
		for(Correspondence c : matching.getCorrespondences()){
			EObject matchedA = c.getMatchedA();
			EObject matchedB = c.getMatchedB();
			correspondences.put(matchedA, matchedB);
			if(mandatoryEObjects.contains(matchedA) && mandatoryEObjects.contains(matchedB)){
				Element elementA = importEObject(matchedA);
				c.setMatchedA(elementA);
				
				Element elementB = importEObject(matchedB);
				c.setMatchedB(elementB);
				
				assert elementA.equals(elementB) : "Corresponding EObjects must be mapped onto the same superimposed element!";
				elementA.getAnnotations().add(annotation_c);
				
				for(EAttribute eAttribute : matchedA.eClass().getEAllAttributes()) {
					if (!eAttribute.isDerived()) {
						Object objectA = matchedA.eGet(eAttribute);
						Object objectB = matchedB.eGet(eAttribute);
						
						if(objectA != null && objectB != null && objectA.equals(objectB) ) {
						
							Attribute attribute = this.importEAttribute(eAttribute, matchedA);
							attribute.getAnnotations().add(annotation_c);
						
						}
					}
				}
				for(EReference eReference : matchedA.eClass().getEAllReferences()) {
					if(!eReference.isDerived()) {
						Object tgtA = matchedA.eGet(eReference);
						Object tgtB = matchedB.eGet(eReference);
						List<EObject> tgtsA = new ArrayList<EObject>();
						List<EObject> tgtsB = new ArrayList<EObject>();
						if(tgtA != null && tgtB != null){
							if(eReference.isMany()){
								tgtsA.addAll((List<EObject>)tgtA);
								tgtsB.addAll((List<EObject>)tgtA);
							}else{
								tgtsA.add((EObject)tgtA);
								tgtsB.add((EObject)tgtB);
							}
							for(EObject eObjectA : tgtsA) {
								if(correspondences.get(elementA) != null) {
									Reference reference = importEReference(eReference, matchedA, eObjectA);
									reference.getAnnotations().add(annotation_c);
								}
							}
						}
						
					}
				}
			}
		}
		
		// Unmatched A
		Set<EObject> unmatchedA = new HashSet<EObject>(matching.getUnmatchedA());
		for(EObject eObject : unmatchedA){
			if(mandatoryEObjects.contains(eObject)) {
				Element element = importEObject(eObject);
				matching.getUnmatchedA().add(element);
				matching.getUnmatchedA().remove(eObject);
			}
		}
		
		// Unmatched B
		Set<EObject> unmatchedB = new HashSet<EObject>(matching.getUnmatchedB());
		for(EObject eObject : unmatchedB){
			if(mandatoryEObjects.contains(eObject)) {
				Element element = importEObject(eObject);
				matching.getUnmatchedB().add(element);
				matching.getUnmatchedB().remove(eObject);
			}
		}
	}
	
	/**
	 * 
	 * @param editRuleMatch
	 * @throws ImportFailedException 
	 */
	private void importEditRuleMatch(EditRuleMatch editRuleMatch) throws ImportFailedException {
		
		
		// node occurrences in a
		for (String nodeOccurrenceA_key : editRuleMatch.getNodeOccurrencesA().keySet()) {

			EObjectSet eObjectSet = SymmetricFactory.eINSTANCE.createEObjectSet();

			for (EObject srcObject : editRuleMatch.getNodeOccurrencesA().get(nodeOccurrenceA_key).getElements()) {

				Element elementA = importEObject(srcObject);
				eObjectSet.addElement(elementA);

			}
			editRuleMatch.getNodeOccurrencesA().put(nodeOccurrenceA_key, eObjectSet);
		}

		// node occurrences in b
		for (String nodeOccurrenceB_key : editRuleMatch.getNodeOccurrencesB().keySet()) {

			EObjectSet eObjectSet = SymmetricFactory.eINSTANCE.createEObjectSet();

			for (EObject srcObject : editRuleMatch.getNodeOccurrencesB().get(nodeOccurrenceB_key).getElements()) {

				Element elementB = importEObject(srcObject);
				eObjectSet.addElement(elementB);

			}
			editRuleMatch.getNodeOccurrencesB().put(nodeOccurrenceB_key, eObjectSet);
		}
	}


	/**
	 * 
	 * @param change
	 * @throws ImportFailedException
	 */
	private void importChange(Change change) throws ImportFailedException{
		// RemoveObject
		if (change instanceof RemoveObject) {

			RemoveObject removeObject = (RemoveObject) change;
			EObject eObject = removeObject.getObj();
			
			Element elementA = importEObject(eObject);
			removeObject.setObj(elementA);
			elementA.getAnnotations().add(annotation_rem);
			
			for(EAttribute eAttribute : eObject.eClass().getEAllAttributes()) {
				if (!eAttribute.isDerived()) {
					Attribute attribute = this.importEAttribute(eAttribute, eObject);
					attribute.getAnnotations().add(annotation_rem);
				}
			}
		}else
	
		// RemoveReference
		if (change instanceof RemoveReference) {

			RemoveReference removeReference = (RemoveReference) change;

			Reference referenceA = importEReference(removeReference.getType(), removeReference.getSrc(), removeReference.getTgt());
			removeReference.setSrc(referenceA.getSource());
			removeReference.setTgt(referenceA.getTarget());
			
			referenceA.getAnnotations().add(annotation_rem);
		}else
		
		// AddObject
		if (change instanceof AddObject) {

			AddObject addObject = (AddObject) change;
			EObject eObject = addObject.getObj();
			
			Element elementB = importEObject(eObject);
			addObject.setObj(elementB);
			elementB.getAnnotations().add(annotation_add);
			
			for(EAttribute eAttribute : eObject.eClass().getEAllAttributes()) {
				if (!eAttribute.isDerived()) {
					Attribute attribute = this.importEAttribute(eAttribute, eObject);
					attribute.getAnnotations().add(annotation_add);
				}
			}
		}else
		
		// AddReference
		if (change instanceof AddReference) {

			AddReference addReference = (AddReference) change;
			
			Reference referenceB = importEReference(addReference.getType(), addReference.getSrc(), addReference.getTgt());
			addReference.setSrc(referenceB.getSource());
			addReference.setTgt(referenceB.getTarget());
			
			referenceB.getAnnotations().add(annotation_add);
		}else
		
		// AttributeValueChange
		if (change instanceof AttributeValueChange) {

			AttributeValueChange attributeValueChange = (AttributeValueChange) change;
			
			Element elementA = importEObject(attributeValueChange.getObjA());
			Attribute attributeA = this.importEAttribute(attributeValueChange.getType(), attributeValueChange.getObjA());
			attributeA.getAnnotations().add(annotation_rem);
			
			Element elementB = importEObject(attributeValueChange.getObjB());
			Attribute attributeB = this.importEAttribute(attributeValueChange.getType(), attributeValueChange.getObjB());
			attributeB.getAnnotations().add(annotation_add);
			
			assert elementA.equals(elementB): "should be the same";
		
			attributeValueChange.setObjA(elementA);
			attributeValueChange.setObjB(elementB);
		}
	}
	
	/**
	 * 
	 * @param eObjects
	 * @return
	 */
	public Map<EObject, Set<Entity>> resolveEObjects(Collection<EObject> eObjects){
		Map<EObject, Set<Entity>> eObject2Element = new HashMap<EObject, Set<Entity>>();
		
		for(EObject eObject : eObjects){
			String signature = getSuperimposedModel().calculateSignature(eObject);
			
			if(getSignatureIndex().containsKey(signature)){
				eObject2Element.put(eObject, getSignatureIndex().get(signature));
			}
		}
		return eObject2Element;
	}
}
