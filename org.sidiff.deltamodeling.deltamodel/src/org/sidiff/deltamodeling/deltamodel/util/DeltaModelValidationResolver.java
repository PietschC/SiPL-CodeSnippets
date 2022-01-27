package org.sidiff.deltamodeling.deltamodel.util;

import java.util.List;

public class DeltaModelValidationResolver {

	public final static DeltaModelValidationResolver INSTANCE = new DeltaModelValidationResolver();
	
	private DeltaModelValidationResolver() {}
	
	public boolean resolve(int sourceID, Object context, List<Object> objects) {
		switch (sourceID) {
//		case DeltaModelValidator.MINIMAL_APPLICATION_ORDER_CONSTRAINT:
//			return resolveMinimalApplicationOrderConstraint(context, objects);
		default:
			return false;
		}
	}
	
	
//	private boolean resolveMinimalApplicationOrderConstraint(Object context, List<Object> objects) {
//		assert DeltaModule.class.isAssignableFrom(context.getClass()): "Delta Module as context expected!";
//		DeltaModule deltaModule = (DeltaModule) context;
//
//		for (ConstraintGroup group : deltaModule.getApplicationOrderConstraints()) {
//			group.getDeltaModules().removeAll(objects);
//		}
//		
//		return true;
//	}
	
	public boolean isResolvable(int sourceID) {
//		return sourceID == DeltaModelValidator.MINIMAL_APPLICATION_ORDER_CONSTRAINT;
		return false;
	}
}
