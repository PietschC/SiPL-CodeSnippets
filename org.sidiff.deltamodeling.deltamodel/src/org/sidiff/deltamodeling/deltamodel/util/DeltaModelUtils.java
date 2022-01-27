package org.sidiff.deltamodeling.deltamodel.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.sidiff.common.collections.TopologicalSorter;
import org.sidiff.deltamodeling.deltamodel.ConstraintGroup;
import org.sidiff.deltamodeling.deltamodel.DeltaModelFactory;
import org.sidiff.deltamodeling.deltamodel.DeltaModule;
import org.sidiff.deltamodeling.deltamodel.DeltaModuleSet;

/**
 * 
 * @author cpietsch
 *
 */
public class DeltaModelUtils{
	
	public static boolean isCoreModule(DeltaModule deltaModule) {
		return ((DeltaModuleSet) deltaModule.eContainer()).getCoreModel().getCoreModule().equals(deltaModule);
	}
	
	public static Optional<ConstraintGroup> getConstraintGroup(DeltaModule deltaModule) {
		DeltaModuleSet dms = (DeltaModuleSet) deltaModule.eContainer();
		return dms.getApplicationOrderConstraints().stream().filter(g -> g.getDeltaModules().contains(deltaModule)).findAny();
	}

	
	public  static Collection<DeltaModule> getAllSuccessors_(DeltaModule deltaModule) {
		DeltaModuleSet dms = (DeltaModuleSet) deltaModule.eContainer();
		Optional<ConstraintGroup> constraintGroup = getConstraintGroup(deltaModule);
		Set<DeltaModule> successors = new HashSet<DeltaModule>();
		int index = -1;
		if(constraintGroup.isPresent()) {
			index = dms.getApplicationOrderConstraints().indexOf(constraintGroup.get())+1;
		}else if(DeltaModelUtils.isCoreModule(deltaModule)) {
			index = 0;
		}
		if(index >=-1) {
			for(int i = index; i < dms.getApplicationOrderConstraints().size(); i++) {
				successors.addAll(dms.getApplicationOrderConstraints().get(i).getDeltaModules());
			}
		}
		return successors;
	}
	
	public static Collection<DeltaModule> getAllPredecessors_(DeltaModule deltaModule) {
		DeltaModuleSet dms = (DeltaModuleSet) deltaModule.eContainer();
		Optional<ConstraintGroup> constraintGroup = getConstraintGroup(deltaModule);
		Set<DeltaModule> predecessors = new HashSet<DeltaModule>();
		if(constraintGroup.isPresent()) {
			for(int i = dms.getApplicationOrderConstraints().indexOf(constraintGroup.get()) -1; i >= 0; i--) {
				predecessors.addAll(dms.getApplicationOrderConstraints().get(i).getDeltaModules());
			}
		}
		if(!DeltaModelUtils.isCoreModule(deltaModule)) {
			predecessors.add(dms.getCoreModel().getCoreModule());
		}
		return predecessors;
	}
	
	public static List<DeltaModule> sort(Collection<DeltaModule> deltaModules, boolean predecessor){
		return DeltaModuleTopologicalSorter.sort(deltaModules, predecessor);
	}
	
	public static EList<ConstraintGroup> getAfter(DeltaModule deltaModule){
		return getAfter(deltaModule, true);
	}
	
	private static EList<ConstraintGroup> getAfter(DeltaModule deltaModule, boolean dependent){
		EList<ConstraintGroup> after = new BasicEList<ConstraintGroup>();
		DeltaModuleSet deltaModuleSet = (DeltaModuleSet) deltaModule.eContainer();
		Optional<ConstraintGroup> constraintGroup = getConstraintGroup(deltaModule);
			if (constraintGroup.isPresent()) {
				for (int i = deltaModuleSet.getApplicationOrderConstraints().indexOf(constraintGroup.get())-1; i >= 0; i--) {
					Set<DeltaModule> deltaModules = new HashSet<DeltaModule>();
				
					for (DeltaModule dm : deltaModuleSet.getApplicationOrderConstraints().get(i).getDeltaModules()) {
						if(dependent) {
							if (deltaModule.getOutgoingDependencyRelations().stream()
									.anyMatch(r -> r.getTargetDeltaModule().equals(dm) && !r.isVoid())
									|| deltaModule.getOutgoingApplicationConditionDependencyRelations().stream()
											.anyMatch(r -> r.getTargetDeltaModules().contains(dm) && !r.isVoid())) {
								deltaModules.add(dm);
							}
						}else {
							deltaModules.add(dm);
						}
					}
					if (!deltaModules.isEmpty()) {
						ConstraintGroup predecessorGroup = DeltaModelFactory.eINSTANCE.createConstraintGroup();
						predecessorGroup.getDeltaModules().addAll(deltaModules);
						after.add(predecessorGroup);
					}
				}
			
		}
		return after;
	}
	
	public static EList<ConstraintGroup> getBefore(DeltaModule deltaModule) {
		return getBefore(deltaModule, true);
	}
	
	private static EList<ConstraintGroup> getBefore(DeltaModule deltaModule, boolean dependent) {
		EList<ConstraintGroup> before = new BasicEList<ConstraintGroup>();
		DeltaModuleSet deltaModuleSet = (DeltaModuleSet) deltaModule.eContainer();
		Optional<ConstraintGroup> constraintGroup = getConstraintGroup(deltaModule);
			if (constraintGroup.isPresent()) {
				for (int i = deltaModuleSet.getApplicationOrderConstraints().indexOf(constraintGroup.get())+1; i < deltaModuleSet.getApplicationOrderConstraints().size()-1; i++) {
					Set<DeltaModule> deltaModules = new HashSet<DeltaModule>();
					for (DeltaModule dm : deltaModuleSet.getApplicationOrderConstraints().get(i).getDeltaModules()) {
						if(dependent) {
							if (deltaModule.getIncomingDependencyRelations().stream()
									.anyMatch(r -> r.getSourceDeltaModule().equals(dm) && !r.isVoid())||
									deltaModule.getIncomingApplicationConditionDependencyRelations().stream().anyMatch(r -> r.getSourceDeltaModule().equals(dm) && !r.isVoid())) {
								deltaModules.add(dm);
							}
						}else {
							deltaModules.add(dm);
						}
					}
					if (!deltaModules.isEmpty()) {
						ConstraintGroup successorGroup = DeltaModelFactory.eINSTANCE.createConstraintGroup();
						successorGroup.getDeltaModules().addAll(deltaModules);
						before.add(successorGroup);
					}
				}
			
		}
		return before;
	}
	
	public static EList<DeltaModule> getAllPredecessors(DeltaModule deltaModule) {
		EList<DeltaModule> predecessors = new BasicEList<DeltaModule>();
		
		for(ConstraintGroup constraingGroup : deltaModule.getAfter()) {
			for(DeltaModule predecessor : constraingGroup.getDeltaModules()) {
				if(!predecessors.contains(predecessor)) {
					predecessors.add(predecessor);
					predecessors.addAll(getAllPredecessors(predecessor));
				}
			}
		}
		
		return predecessors;
	}
	
	public static EList<DeltaModule> getAllSuccessors(DeltaModule deltaModule) {
		EList<DeltaModule> successors = new BasicEList<DeltaModule>();
		
		for(ConstraintGroup constraingGroup : deltaModule.getBefore()) {
			for(DeltaModule successor : constraingGroup.getDeltaModules()) {
				if(!successors.contains(successor)) {
					successors.add(successor);
					successors.addAll(getAllSuccessors(successor));
				}
			}
		}
		
		return successors;
	}
	
	private static class DeltaModuleTopologicalSorter extends TopologicalSorter<DeltaModule> {
		
		public static final Function<DeltaModule, Stream<DeltaModule>> PREDECESSORS = (v) -> getAfter(v, false).stream().flatMap(constraintGroup -> constraintGroup.getDeltaModules().stream());
		
		private DeltaModuleTopologicalSorter(Collection<DeltaModule> vertices, boolean proceeding) {
			super(vertices, PREDECESSORS, proceeding);
		}
	
		public static List<DeltaModule> sort(Collection<DeltaModule> vertices, boolean proceeding){
			return new DeltaModuleTopologicalSorter(vertices, proceeding).sort();
		}
	}
	
	
	public static boolean equalApplicationOrderConstraints(List<ConstraintGroup> apoc1, List<ConstraintGroup> apoc2) {
		if(apoc1.size() != apoc2.size()) {
			return false;
		}else {
			for(int i = 0; i < apoc1.size(); i++) {
				if(apoc1.get(i).getDeltaModules().size() != apoc2.get(i).getDeltaModules().size()) {
					return false;
				}else if(!apoc1.get(i).getDeltaModules().containsAll(apoc2.get(i).getDeltaModules())){
					return false;
				}
			}
		}
		return true;
	}
	
	
	private static class DFSCycleChecker<T> {
		private Function<T, Stream<T>> adjacentFunction;
		private Set<T> vertices;
		private Set<List<T>> cycles;
		
		public DFSCycleChecker (Collection<T> vertices, Function<T, Stream<T>> adjacentFunction) {
			this.vertices = new HashSet<T>(vertices);
			this.adjacentFunction = adjacentFunction;
	
			this.cycles = new HashSet<List<T>>();
		}
		
		public boolean check() {
			for(T vertex : vertices) {
				List<T> path = new ArrayList<T>();
				visit(vertex, path);
			}
			return !cycles.isEmpty();
		}
		
		private void visit(T vertex, List<T> path) {
			if(!path.contains(vertex)) {
				path.add(vertex);
				adjacentFunction.apply(vertex).forEach(v -> visit(v, new ArrayList<T>(path)));
			}else {
				if(path.get(0).equals(vertex)) {
					cycles.add(path);
				}
			}
		}
		
		public Set<List<T>> getCycles() {
			return cycles;
		}
	}
}
