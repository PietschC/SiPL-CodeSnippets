package org.sidiff.deltamodeling.deltamodel.superimposition.filter;

import org.sidiff.common.extension.IExtension.Description;
import org.sidiff.common.extension.TypedExtensionManager;

public class EMFImporterFilterManager extends TypedExtensionManager<IEMFImporterFilter> {

	public EMFImporterFilterManager(Description<? extends IEMFImporterFilter> description) {
		super(description);
	}
}
