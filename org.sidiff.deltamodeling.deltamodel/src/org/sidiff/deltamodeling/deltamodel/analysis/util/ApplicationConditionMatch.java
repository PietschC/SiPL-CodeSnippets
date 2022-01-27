package org.sidiff.deltamodeling.deltamodel.analysis.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.deltamodeling.deltamodel.ConflictDetail;
import org.sidiff.deltamodeling.deltamodel.DeltaModule;
import org.sidiff.deltamodeling.deltamodel.DependencyDetail;
import org.sidiff.deltamodeling.deltamodel.Detail;
import org.sidiff.deltamodeling.deltamodel.analysis.IRuleElementMapping;
import org.sidiff.difference.asymmetric.OperationInvocation;
import org.sidiff.entities.Entity;
import org.sidiff.entities.Reference;
import org.sidiff.superimposition.SuperimposedElement;

public class ApplicationConditionMatch {
	
	private IRuleElementMapping ruleElementMapping;
	private ApplicationConditionRuleWrapper ruleWrapper;
	private Set<GraphElement> graphElements = new HashSet<>();
	private Set<Entity> entities = new HashSet<>();
	private Map<Node, Set<SuperimposedElement>> acNodeMapping = new HashMap<>();
	private Map<Edge, Set<Reference>> acEdgeMapping = new HashMap<>();
	private Map<Attribute, Set<org.sidiff.entities.Attribute>> acAttributeMapping = new HashMap<>();
	private Map<OperationInvocation, PartialConflict> partialConflicts = new HashMap<OperationInvocation, PartialConflict>();
	private Map<OperationInvocation, PartialDependency> partialDependencies = new HashMap<OperationInvocation, PartialDependency>();
	private String matchID;
	
	public ApplicationConditionMatch(IRuleElementMapping ruleElementMapping, ApplicationConditionRuleWrapper ruleWrapper) {
		this.ruleElementMapping = ruleElementMapping;
		this.ruleWrapper = ruleWrapper;
		this.matchID = EcoreUtil.generateUUID();
	}
	
	public IRuleElementMapping getRuleElementMapping() {
		return ruleElementMapping;
	}
	
	public ConditionType getType() {
		return ruleWrapper.getType();
	}
	
	public String getACId() {
		return ruleWrapper.getId();
	}
	
	public String getMatchID() {
		return matchID;
	}
	
	public boolean isPac() {
		return ruleWrapper.getType() == ConditionType.PAC;
	}
	
	public boolean isNac() {
		return ruleWrapper.getType() == ConditionType.NAC;
	}
	
	public Set<GraphElement> getGraphElements() {
		return Collections.unmodifiableSet(graphElements);
	}
	
	public Set<Entity> getEntities() {
		return Collections.unmodifiableSet(entities);
	}
	
	public PartialConflict getPartialConflict(OperationInvocation deltaAction) {
		return this.partialConflicts.get(deltaAction);
	}
	
	public PartialDependency getPartialDependency(OperationInvocation deltaAction) {
		return this.partialDependencies.get(deltaAction);
	}
	
	public Map<Node, Set<SuperimposedElement>> getACNodeMapping() {
		return acNodeMapping;
	}

	public Map<Edge, Set<Reference>> getACEdgeMapping() {
		return acEdgeMapping;
	}

	public Map<Attribute, Set<org.sidiff.entities.Attribute>> getACAttributeMapping() {
		return acAttributeMapping;
	}
	
	public void addACNodeMapping(Node node, SuperimposedElement element) {
		add(node, element, this.acNodeMapping);
	}

	public void addACEdgeMapping(Edge edge, Reference reference) {
		add(edge, reference, this.acEdgeMapping);
	}

	public void addACAttributeMapping(Attribute attribute, org.sidiff.entities.Attribute entityAttribute) {
		add(attribute, entityAttribute, this.acAttributeMapping);
	}
	
	private <G extends GraphElement, E extends Entity> void add(G graphElement, E entity, Map<G, Set<E>> map) {
		if (!map.containsKey(graphElement)) {
			map.put(graphElement, new HashSet<E>());
		}
		map.get(graphElement).add(entity);
		graphElements.add(graphElement);
		entities.add(entity);
	}
	
	public void addPartialConflict(DeltaModule deltaModule, OperationInvocation deltaAction, ConflictDetail detail) {
		if(!this.partialConflicts.containsKey(deltaAction)) {
			this.partialConflicts.put(deltaAction, new PartialConflict(this, deltaModule, deltaAction));
			this.partialConflicts.get(deltaAction).addDetail(detail);
		}else {
			PartialConflict partialConflict = partialConflicts.get(deltaAction);
			if(partialConflict.getDetails().stream().noneMatch(existingDetail -> existingDetail.getKind() == detail.getKind() && existingDetail.getEntities().equals(detail.getEntities()))) {
				this.partialConflicts.get(deltaAction).addDetail(detail);
			}
		}
		
	}
	
	public void addPartialDependency(DeltaModule deltaModule, OperationInvocation deltaAction, DependencyDetail detail) {
		if(!this.partialDependencies.containsKey(deltaAction)) {
			this.partialDependencies.put(deltaAction, new PartialDependency(this, deltaModule, deltaAction));
		}else{
			PartialDependency partialDependency = partialDependencies.get(deltaAction);
			if(partialDependency.getDetails().stream().noneMatch(existingDetail -> existingDetail.getKind() == detail.getKind() && existingDetail.getEntities().equals(detail.getEntities()))) {
				this.partialDependencies.get(deltaAction).addDetail(detail);
			}
		}
		this.partialDependencies.get(deltaAction).addDetail(detail);
	}
	
	@Override
	public boolean equals(Object obj) {
		// reflexive
		if(this == obj) {
			return true;
		}
		
		if(obj == null || !(obj instanceof ApplicationConditionMatch)) {
			return false;
		}
		
		ApplicationConditionMatch acm = (ApplicationConditionMatch) obj;
		
		return acm.getACId().equals(this.getACId()) && this.graphElements.equals(acm.getGraphElements()) && this.entities.equals(acm.getEntities());
	}
	
	@Override
	public int hashCode() {
		int hash = 17;
		hash += 31 * hash + getACId().hashCode();
		hash += 31 * hash + graphElements.hashCode();
		hash += 31 * hash + entities.hashCode();
		return hash;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(OperationInvocation opInv : partialConflicts.keySet()) {
			builder.append(opInv.getName());
			builder.append(": \n");
			
			for(Detail detail : partialConflicts.get(opInv).getDetails()) {
				builder.append(detail.getEntities());
				builder.append("\n");
			}
			builder.append("\n");
		}
		return builder.toString();
	}
	
	public Set<Set<PartialConflict>> combinePartialConflicts(){
		if(this.isNac()) {
			return combine(partialConflicts);
		}else {
			return partialConflicts.values().isEmpty()? Collections.emptySet() : Collections.singleton(new HashSet<>(partialConflicts.values()));
		}
	}
	
	public Set<Set<PartialDependency>> combinePartialDependencies(){
		if(this.isNac()) {
			return partialDependencies.values().isEmpty()? Collections.emptySet(): Collections.singleton(new HashSet<>(partialDependencies.values()));
		}else {
			return combine(partialDependencies);
		}
	}
	
	private <T extends PartialRelation<?>> Set<Set<T>> combine(Map<OperationInvocation, T> partialRelations){
		Set<Set<T>> result = new HashSet<Set<T>>();
		Map<Entity, Set<T>> coverage = new HashMap<Entity, Set<T>>();
	
		for(Entity entity : entities) {
			coverage.put(entity, new HashSet<T>());
			for (T partialRelation : partialRelations.values()) {
				if (partialRelation.getDetails().stream().anyMatch(d -> d.getEntities().contains(entity))) {
					coverage.get(entity).add(partialRelation);
				}
			}
		}
		
		for(Entity entity: entities) {
			Set<T> entityMatches = coverage.get(entity);
			if(!entityMatches.isEmpty()) {
				pow(coverage.get(entity), result);
			}
		}
				
		return result;
	}
	
	private <T extends PartialRelation<?>> void pow(Set<T> entityMatches, Set<Set<T>> result) {
		if(result.isEmpty()) {
			for(T partialRelation : entityMatches) {
				Set<T> set = new HashSet<T>();
				set.add(partialRelation);
				result.add(set);
			}
		}else {
			List<Set<Set<T>>> tmp = new ArrayList<>();
			for(int i=0; i< entityMatches.size(); i++) {
				Set<Set<T>> tmpResult = new HashSet<Set<T>>();
				for(Set<T> origin : result) {
					Set<T> copy = new HashSet<T>(origin);
					tmpResult.add(copy);
				}
				tmp.add(tmpResult);
			}
		
			int i = 0;
			for(T partialRelation : entityMatches) {
				for(Set<T> set : tmp.get(i)) {
					if(set.stream().noneMatch(p -> p.getEntities().equals(partialRelation.getEntities()))) {
						set.add(partialRelation);
					}
				}
				i++;
			}
			
			result.clear();
			for(int j = 0; j < tmp.size(); j++) {
				result.addAll(tmp.get(j));
			}
		}
	}
	
	public static abstract class PartialRelation <T extends Detail> {
		protected ApplicationConditionMatch applicationConditionMatch;
		protected DeltaModule deltaModule;
		protected OperationInvocation deltaAction;
		protected Set<T> details;
		protected Set<Entity> entities;
		
		public PartialRelation(ApplicationConditionMatch applicationConditionMatch, DeltaModule deltaModule, OperationInvocation deltaAction) {
			this.applicationConditionMatch = applicationConditionMatch;
			this.deltaModule = deltaModule;
			this.deltaAction = deltaAction;
			this.details = new HashSet<T>();
			this.entities = new HashSet<Entity>();
		}
		
		public OperationInvocation getDeltaAction() {
			return deltaAction;
		}
		
		public DeltaModule getDeltaModule() {
			return deltaModule;
		}
		
		public Set<Entity> getEntities() {
			return Collections.unmodifiableSet(entities);
		}
		
		public void addDetail(T detail) {
			this.details.add(detail);
			this.entities.addAll(detail.getEntities());
		}
		
		public Set<T> getDetails() {
			return Collections.unmodifiableSet(details);
		};
		
		@Override
		public String toString() {
			return deltaModule.getName();
		}
		
		public boolean isCompleteMatch() {
			return this.applicationConditionMatch.getEntities().equals(this.entities);
		}
	}
	
	public static class PartialConflict extends PartialRelation<ConflictDetail> {
				
		public PartialConflict(ApplicationConditionMatch applicationConditionMatch, DeltaModule deltaModule, OperationInvocation deltaAction) {
			super(applicationConditionMatch, deltaModule, deltaAction);
		}

	}
	
	public static class PartialDependency extends PartialRelation<DependencyDetail> {

		public PartialDependency(ApplicationConditionMatch applicationConditionMatch, DeltaModule deltaModule, OperationInvocation deltaAction) {
			super(applicationConditionMatch, deltaModule, deltaAction);
		}
	
	}
}
