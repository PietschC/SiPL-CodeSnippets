package org.sidiff.deltamodeling.deltamodel.superimposition.filter;

import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.entities.importer.filter.IImporterFilter;

public class ExtendableEMFImporterFilter implements IImporterFilter {
	
	private IEMFImporterFilter internal_filter;
	
	public void init(Set<String> documentTypes) {
		internal_filter = IEMFImporterFilter.MANAGER.getDefaultExtension(documentTypes).orElse(null);
	}
	
	@Override
	public boolean isConsidered(EObject eObject) {
		return !EMFUtil.isDynamic(eObject) && (internal_filter != null ? internal_filter.isConsidered(eObject) : true);
	}

	@Override
	public boolean isConsidered(EReference eReference, EObject eObject) {
		return !(eReference.isDerived() || (eReference.getEType() == EcorePackage.eINSTANCE.getEGenericType() // special case for references referencing generic types
		 		&& eReference.getEContainingClass().isSuperTypeOf(eObject.eClass()) // prevent exceptions because of undefined features
		 		&& EMFUtil.getReferenceTargets(eObject, eReference).stream().allMatch(EMFUtil::isDynamic))) // dynamic if all targets are dynamic
				&& (internal_filter != null? internal_filter.isConsidered(eReference, eObject) : true);
	}

	@Override
	public boolean isConsidered(EAttribute eAttribute, EObject eObject) {
		return (internal_filter != null ? internal_filter.isConsidered(eAttribute, eObject) : true);
	}

}
