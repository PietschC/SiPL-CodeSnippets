package org.sidiff.deltamodeling.deltamodel.superimposition.filter;

import org.sidiff.common.extension.ITypedExtension;
import org.sidiff.entities.importer.filter.IImporterFilter;

public interface IEMFImporterFilter extends IImporterFilter, ITypedExtension {
	
	Description<IEMFImporterFilter> DESCRIPTION = Description.of(IEMFImporterFilter.class, "org.sidiff.deltamodeling.deltamodel.importer_filter", "importer_filter", "class");
	
	EMFImporterFilterManager MANAGER = new EMFImporterFilterManager(DESCRIPTION);
}
