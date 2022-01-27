package org.sidiff.deltamodeling.deltamodel.adapter.exceptions;

import org.sidiff.deltamodeling.deltamodel.adapter.DomainProblemSpaceAdapterExtensionManager;
import org.sidiff.deltamodeling.deltamodel.adapter.IDomainProblemSpaceAdapter;

/**
 * Exception that is thrown if an requested {@link IDomainProblemSpaceAdapter}
 * is not registered by the {@link DomainProblemSpaceAdapterExtensionManager}.
 * 
 * @author cpietsch
 *
 */
public class DomainProblemSpaceAdapterNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private String key;
	
	public DomainProblemSpaceAdapterNotFoundException(String key) {
		this.key = key;
	}

	@Override
	public String getMessage() {
		return "No Domain Problem Space Adapter with key \"" + key + "\" found";
	}
}
