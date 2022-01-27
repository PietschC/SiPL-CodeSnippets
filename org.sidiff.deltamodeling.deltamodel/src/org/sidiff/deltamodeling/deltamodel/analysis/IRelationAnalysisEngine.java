package org.sidiff.deltamodeling.deltamodel.analysis;

import org.eclipse.core.runtime.IProgressMonitor;
import org.sidiff.deltamodeling.deltamodel.DeltaModuleSet;
import org.sidiff.deltamodeling.deltamodel.analysis.impl.RelationAnalysisEngine;

/**
 * The {@link IRelationAnalysisEngine} can be adapted to an existing
 * {@link DeltaModuleSet} in order to perform arbitrary analysis and resolving
 * operations.
 * 
 * 
 * @see {@link RelationAnalysisEngine} as implementation for analyzing and
 *      resolving conflicts and dependencies between delta modules and their
 *      delta actions.
 * 
 * @author cpietsch
 *
 */
public interface IRelationAnalysisEngine {
	
	public void analyze(IProgressMonitor monitor);
			
	public void resolve(IProgressMonitor monitor);

}
