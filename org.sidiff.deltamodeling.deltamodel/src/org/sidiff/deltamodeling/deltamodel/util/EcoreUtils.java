package org.sidiff.deltamodeling.deltamodel.util;

import org.eclipse.emf.ecore.EObject;

public class EcoreUtils {

	public static <T extends EObject> T getContainer(EObject eObject, Class<T> type) {
		
		while(eObject != null) {
			if(type.isInstance(eObject)) {
				return type.cast(eObject);
			}
			eObject = eObject.eContainer();
		}

		return null;
	}
}
