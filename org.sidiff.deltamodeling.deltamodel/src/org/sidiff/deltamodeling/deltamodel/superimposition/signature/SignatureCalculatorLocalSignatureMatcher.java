package org.sidiff.deltamodeling.deltamodel.superimposition.signature;

import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.matcher.LocalSignatureMatcher;

public abstract class SignatureCalculatorLocalSignatureMatcher extends LocalSignatureMatcher implements ISignatureMatcher {

	private Function<EObject, String> signatureCalculator;

	@Override
	protected String getElementSignature(EObject element) {
		return signatureCalculator.apply(element);
	}

	@Override
	protected boolean considerCandidatesOnly() {
		return false;
	}

	@Override
	public void setSignatureCalculator(Function<EObject, String> signatureCalculator) {
		this.signatureCalculator = signatureCalculator;
	}
}
