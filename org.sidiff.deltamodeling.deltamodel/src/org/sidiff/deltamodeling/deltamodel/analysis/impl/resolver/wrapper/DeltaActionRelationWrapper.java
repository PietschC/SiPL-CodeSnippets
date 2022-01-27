/**
 * 
 */
package org.sidiff.deltamodeling.deltamodel.analysis.impl.resolver.wrapper;

import org.sidiff.formula.Formula;

/**
 * @author cpietsch
 *
 */
public abstract class DeltaActionRelationWrapper<T> {
	
	protected T wrappy;
		
	public DeltaActionRelationWrapper(T wrappy){
		this.wrappy = wrappy;
	}
	
	public T getWrappy() {
		return this.wrappy;
	}
	
	public abstract Formula getFormula();
	
}
