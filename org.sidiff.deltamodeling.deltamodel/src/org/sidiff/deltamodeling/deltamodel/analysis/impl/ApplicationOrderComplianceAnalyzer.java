package org.sidiff.deltamodeling.deltamodel.analysis.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionKind;
import org.sidiff.deltamodeling.deltamodel.ConflictRelation;
import org.sidiff.deltamodeling.deltamodel.ConstraintGroup;
import org.sidiff.deltamodeling.deltamodel.DeltaModuleSet;
import org.sidiff.deltamodeling.deltamodel.DependencyRelation;
import org.sidiff.deltamodeling.deltamodel.TransientEffectRelation;
import org.sidiff.deltamodeling.deltamodel.analysis.util.AnalysisUtils;
import org.sidiff.deltamodeling.deltamodel.util.DeltaModelUtils;

/**
 * An {@link ApplicationOrderComplianceAnalyzer} provides analysis operations
 * for checking the correctness of specified application order constraints
 * between delta modules.
 * 
 * @author cpietsch
 *
 */
public class ApplicationOrderComplianceAnalyzer {
	
	/**
	 * Analyzes a {@link ConflictRelation} if it really occurs regarding the
	 * application order constraints.
	 * 
	 * @param relation the {@link ConflictRelation} to be analyzed
	 * @param monitor  an {@link IProgressMonitor}
	 * @return the application order of the involved delta modules as counter
	 *         example or an empty list
	 */
	public List<ConstraintGroup> analyze(ConflictRelation relation, IProgressMonitor monitor) {
		DeltaModuleSet dms = (DeltaModuleSet) relation.eContainer();
		List<ConstraintGroup> constraintGroups = new ArrayList<ConstraintGroup>();
		Optional<ConstraintGroup> srcConstraintGroup = DeltaModelUtils
				.getConstraintGroup(relation.getSourceDeltaModule());
		Optional<ConstraintGroup> tgtConstraintGroup = DeltaModelUtils
				.getConstraintGroup(relation.getTargetDeltaModule());
		if (srcConstraintGroup.isPresent() && tgtConstraintGroup.isPresent()) {

			int srcIndex = dms.getApplicationOrderConstraints().indexOf(srcConstraintGroup.get());
			int tgtIndex = dms.getApplicationOrderConstraints().indexOf(tgtConstraintGroup.get());
			if (srcIndex > tgtIndex) {
				for (int i = srcIndex; i >= tgtIndex; i--) {
					constraintGroups.add(dms.getApplicationOrderConstraints().get(i));
				}
			}
		}

		return constraintGroups;
	}
	
	/**
	 * Analyzes a {@link ApplicationConditionConflictRelation} if it really occurs regarding the
	 * application order constraints.
	 * 
	 * @param relation the {@link ApplicationConditionConflictRelation} to be analyzed
	 * @param monitor  an {@link IProgressMonitor}
	 * @return the application order of the involved delta modules as counter
	 *         example or an empty list
	 */
	public List<ConstraintGroup> analyze(ApplicationConditionConflictRelation relation, IProgressMonitor monitor){
		DeltaModuleSet dms = (DeltaModuleSet) relation.eContainer();
		List<ConstraintGroup> constraintGroups = new ArrayList<ConstraintGroup>();
		Set<Optional<ConstraintGroup>> srcConstraintGroups = relation.getSourceDeltaModules().stream().map(source -> DeltaModelUtils.getConstraintGroup(source)).collect(Collectors.toSet());
		Optional<ConstraintGroup> tgtConstraintGroup = DeltaModelUtils
				.getConstraintGroup(relation.getTargetDeltaModule());
		boolean isNac = AnalysisUtils.isNegativeApplicationConditionRelation(relation);
		
		if (tgtConstraintGroup.isPresent() && srcConstraintGroups.stream().allMatch(group -> group.isPresent())) {
			int tgtIndex = dms.getApplicationOrderConstraints().indexOf(tgtConstraintGroup.get());
			for (Optional<ConstraintGroup> srcConstraintGroup : srcConstraintGroups) {
				int srcIndex = dms.getApplicationOrderConstraints().indexOf(srcConstraintGroup.get());
				if (srcIndex > tgtIndex) {
					for (int i = srcIndex; i >= tgtIndex; i--) {
						constraintGroups.add(dms.getApplicationOrderConstraints().get(i));
					}
				} else if (!isNac) {
					constraintGroups.clear();
				}
			}
		}

		return constraintGroups;
	}
	
	/**
	 * Analyzes a {@link DependencyRelation} if it really occurs regarding the
	 * application order constraints.
	 * 
	 * @param relation the {@link DependencyRelation} to be analyzed
	 * @param monitor  and {@link IProgressMonitor}
	 * @return the application order of the involved delta modules as counter
	 *         example or an empty list
	 */
	public List<ConstraintGroup> analyze(DependencyRelation relation, IProgressMonitor monitor){
		DeltaModuleSet dms = (DeltaModuleSet) relation.eContainer();
		List<ConstraintGroup> constraintGroups = new ArrayList<ConstraintGroup>();
		Optional<ConstraintGroup> srcConstraintGroup = DeltaModelUtils
				.getConstraintGroup(relation.getSourceDeltaModule());
		Optional<ConstraintGroup> tgtConstraintGroup = DeltaModelUtils
				.getConstraintGroup(relation.getTargetDeltaModule());
		
		if (srcConstraintGroup.isPresent() && tgtConstraintGroup.isPresent()) {

			int srcIndex = dms.getApplicationOrderConstraints().indexOf(srcConstraintGroup.get());
			int tgtIndex = dms.getApplicationOrderConstraints().indexOf(tgtConstraintGroup.get());
			if (srcIndex <= tgtIndex) {
				for (int i = srcIndex; i <= tgtIndex; i++) {
					constraintGroups.add(dms.getApplicationOrderConstraints().get(i));
				}
			}
		}
		
		return constraintGroups;
	}
	
	/**
	 * Analyzes a {@link ApplicationConditionDependencyRelation} if it really occurs regarding the
	 * application order constraints.
	 * 
	 * @param relation the {@link ApplicationConditionDependencyRelation} to be analyzed
	 * @param monitor  and {@link IProgressMonitor}
	 * @return the application order of the involved delta modules as counter
	 *         example or an empty list
	 */
	public List<ConstraintGroup> analyze(ApplicationConditionDependencyRelation relation, IProgressMonitor monitor){
		DeltaModuleSet dms = (DeltaModuleSet) relation.eContainer();
		List<ConstraintGroup> constraintGroups = new ArrayList<ConstraintGroup>();
		Set<Optional<ConstraintGroup>> tgtConstraintGroups = relation.getTargetDeltaModules().stream().map(target -> DeltaModelUtils.getConstraintGroup(target)).collect(Collectors.toSet());
		Optional<ConstraintGroup> srcConstraintGroup = DeltaModelUtils
				.getConstraintGroup(relation.getSourceDeltaModule());
		
		boolean isNac = relation.getApplicationConditionDependencies().stream().allMatch(d -> d.getKind() == ApplicationConditionKind.NAC);
		if(srcConstraintGroup.isPresent() && tgtConstraintGroups.stream().allMatch(group -> group.isPresent())) {
			int srcIndex = dms.getApplicationOrderConstraints().indexOf(srcConstraintGroup.get());
			for(Optional<ConstraintGroup> tgtConstraintGroup : tgtConstraintGroups) {
				int tgtIndex = dms.getApplicationOrderConstraints().indexOf(tgtConstraintGroup.get());
				if (srcIndex <= tgtIndex) {
					for (int i = srcIndex; i <= tgtIndex; i++) {
						constraintGroups.add(dms.getApplicationOrderConstraints().get(i));
					}
				}else if(isNac){
					constraintGroups.clear();
					break;
				}
			}
		}
		return constraintGroups;
	}
	
	/**
	 * Analyzes a {@link TransientEffectRelation} if it really occurs regarding the
	 * application order constraints.
	 * 
	 * @param relation the {@link TransientEffectRelation} to be analyzed
	 * @param monitor  an {@link IProgressMonitor}
	 * @return the application order of the involved delta modules as counter
	 *         example or an empty list
	 */
	public List<ConstraintGroup> analyze(TransientEffectRelation relation, IProgressMonitor monitor){
		DeltaModuleSet dms = (DeltaModuleSet) relation.eContainer();
		List<ConstraintGroup> constraintGroups = new ArrayList<ConstraintGroup>();
		Optional<ConstraintGroup> srcConstraintGroup = DeltaModelUtils
				.getConstraintGroup(relation.getSourceDeltaModule());
		Optional<ConstraintGroup> tgtConstraintGroup = DeltaModelUtils
				.getConstraintGroup(relation.getTargetDeltaModule());
		
		if (srcConstraintGroup.isPresent() && tgtConstraintGroup.isPresent()) {

			int srcIndex = dms.getApplicationOrderConstraints().indexOf(srcConstraintGroup.get());
			int tgtIndex = dms.getApplicationOrderConstraints().indexOf(tgtConstraintGroup.get());
			if (srcIndex <= tgtIndex) {
				for (int i = srcIndex; i <= tgtIndex; i++) {
					constraintGroups.add(dms.getApplicationOrderConstraints().get(i));
				}
			}
		}
		
		return constraintGroups;
	}
}
