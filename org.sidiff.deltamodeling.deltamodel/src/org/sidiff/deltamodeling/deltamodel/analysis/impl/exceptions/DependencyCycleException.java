package org.sidiff.deltamodeling.deltamodel.analysis.impl.exceptions;

import java.util.List;

import org.sidiff.deltamodeling.deltamodel.Relation;

public class DependencyCycleException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7878808112734729268L;
	
	private List<Relation> relations;

	public DependencyCycleException(List<Relation> relations) {
		super("Dependency Cycle Error");
		this.relations = relations;
	}

	public List<Relation> getRelations() {
		return relations;
	}

}
