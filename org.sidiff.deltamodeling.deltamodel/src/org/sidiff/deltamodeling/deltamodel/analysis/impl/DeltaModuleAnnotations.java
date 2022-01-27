package org.sidiff.deltamodeling.deltamodel.analysis.impl;

import org.sidiff.deltamodeling.deltamodel.DeltaModule;
import org.sidiff.deltamodeling.deltamodel.superimposition.util.AnnotationUtil;
import org.sidiff.entities.Annotation;

/**
 * Delta module Annotations are classified according to the modifications of the
 * contained delta actions, i.e.: delete = 'not{@link DeltaModule#getName()})'
 * preserve = 'not{@link DeltaModule#getName()}) or {@link DeltaModule#getName()}' 
 * create = '{@link DeltaModule#getName()}'
 * 
 * @author cpietsch
 *
 */
public class DeltaModuleAnnotations {

	/**
	 * Annotation for elements to be deleted
	 */
	private Annotation deleteAnnotation;
	
	/**
	 * Annotation for elements to be preserved
	 */
	private Annotation preserveAnnotation;
	
	/**
	 * Annotation for elements to be created
	 */
	private Annotation createAnnotation;
	
	/**
	 * Constructor that initializes the respective annotations.
	 * 
	 * @param deltaModule the {@link DeltaModule} for that the annotations should be
	 *                    initialized
	 */
	public DeltaModuleAnnotations(DeltaModule deltaModule) {
		this.deleteAnnotation = AnnotationUtil.initDeleteAnnotation(deltaModule);
		this.preserveAnnotation = AnnotationUtil.initPreserveAnnotation(deltaModule);
		this.createAnnotation = AnnotationUtil.initCreateAnnotation(deltaModule);
	}
	
	/**
	 * Getter for delete annotation
	 * 
	 * @return delete annotation
	 */
	public Annotation getDeleteAnnotation() {
		return deleteAnnotation;
	}
	
	/**
	 * Getter for preserve annotation
	 * 
	 * @return preserve annotation
	 */
	public Annotation getPreserveAnnotation() {
		return preserveAnnotation;
	}
	
	/**
	 * Getter for create annotation
	 * 
	 * @return create annotation
	 */
	public Annotation getCreateAnnotation() {
		return createAnnotation;
	}

}
