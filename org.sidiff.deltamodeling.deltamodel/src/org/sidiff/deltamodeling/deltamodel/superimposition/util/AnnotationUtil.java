package org.sidiff.deltamodeling.deltamodel.superimposition.util;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.deltamodeling.deltamodel.CoreModel;
import org.sidiff.deltamodeling.deltamodel.DeltaModule;
import org.sidiff.deltamodeling.deltamodel.DeltaModuleSet;
import org.sidiff.entities.Annotation;
import org.sidiff.entities.util.EntitiesUtil;
import org.sidiff.formula.Formula;
import org.sidiff.formula.Not;
import org.sidiff.formula.Or;
import org.sidiff.formula.util.FormulaUtil;

public class AnnotationUtil {

	public static Annotation initCoreModelAnnotation(CoreModel coreModel) {
		final String body = "CoreModel";
		Annotation annotation = null;
		if(coreModel.eContainer() != null) {
			annotation = ((DeltaModuleSet) coreModel.eContainer()).getSuperimposedModel().getAnnotation(body);
		}
		if(annotation == null) {
			annotation = EntitiesUtil.createModelAnnotation(body);			
		}
		return annotation;
	}

	public static Annotation initDeleteAnnotation(DeltaModule deltaModule) {
		final String body = "not(" + deltaModule.getName() + ")";
		Annotation annotation = null;
		if(deltaModule.eContainer()!= null) {
			annotation = ((DeltaModuleSet) deltaModule.eContainer()).getSuperimposedModel().getAnnotation(body);
		}
		if(annotation == null) {
			annotation = EntitiesUtil.createModelAnnotation(body);
			Not neg_formula = FormulaUtil.createNot(EcoreUtil.copy(deltaModule.getApplicationCondition()));
			annotation.setFormula(neg_formula);
		}
		return annotation;
	}
	
	public static Annotation initCreateAnnotation(DeltaModule deltaModule) {
		final String body = deltaModule.getName();
		Annotation annotation = null;
		if(deltaModule.eContainer()!= null) {
			annotation = ((DeltaModuleSet) deltaModule.eContainer()).getSuperimposedModel().getAnnotation(body);
		}
		if(annotation == null) {
			annotation = EntitiesUtil.createModelAnnotation(body);
			Formula formula = EcoreUtil.copy(deltaModule.getApplicationCondition());
			annotation.setFormula(formula);
		}
		return annotation;
	}
	
	public static Annotation initPreserveAnnotation(DeltaModule deltaModule) {
		final String body = "not(" + deltaModule.getName() + ") or " + deltaModule.getName();
		Annotation annotation = null;
		if(deltaModule.eContainer()!= null) {
			annotation = ((DeltaModuleSet) deltaModule.eContainer()).getSuperimposedModel().getAnnotation(body);
		}
		if(annotation == null) {
			annotation = EntitiesUtil.createModelAnnotation(body);
			// not needed for consistency checking
			Or or_formula = FormulaUtil.createOr(
				FormulaUtil.createNot(EcoreUtil.copy(deltaModule.getApplicationCondition())),
				EcoreUtil.copy(deltaModule.getApplicationCondition()));
			annotation.setFormula(or_formula);
		}
		return annotation;
	}
}
