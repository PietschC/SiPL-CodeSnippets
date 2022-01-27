package org.sidiff.deltamodeling.deltamodel.superimposition.importer;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.deltamodeling.deltamodel.DeltaModuleSet;
import org.sidiff.deltamodeling.deltamodel.superimposition.filter.ExtendableEMFImporterFilter;
import org.sidiff.deltamodeling.deltamodel.superimposition.util.AnnotationUtil;
import org.sidiff.entities.Annotation;
import org.sidiff.entities.importer.ImportFailedException;
import org.sidiff.entities.importer.filter.IImporterFilter;
import org.sidiff.superimposition.importer.SuperimpositionModelImporter;

public class CoreModelImporter extends SuperimpositionModelImporter {

	public CoreModelImporter(Set<String> documentTypes) {
		super();
		((ExtendableEMFImporterFilter)this.getFilter()).init(Collections.unmodifiableSet(documentTypes));		
	}

	@Override
	protected IImporterFilter createFilter() {
		return new ExtendableEMFImporterFilter();
	}

	public void importCoreModel(DeltaModuleSet dms) throws ImportFailedException {
		init(dms.getSuperimposedModel());

		Annotation annotation_coreModel = AnnotationUtil.initCoreModelAnnotation(dms.getCoreModel());
		dms.getSuperimposedModel().getAnnotations().add(annotation_coreModel);

		Resource coreModelResource = dms.getCoreModel().getResource();
		if(coreModelResource == null) { // in case core model was deleted
			removeAllAnnotated(annotation_coreModel);
		} else {
			importResource(coreModelResource, annotation_coreModel);				
		}
	}
}
