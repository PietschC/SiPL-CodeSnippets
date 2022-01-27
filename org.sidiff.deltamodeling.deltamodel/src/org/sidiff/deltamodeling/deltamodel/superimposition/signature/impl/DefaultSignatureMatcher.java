package org.sidiff.deltamodeling.deltamodel.superimposition.signature.impl;

import java.util.function.Consumer;

import org.sidiff.deltamodeling.deltamodel.superimposition.signature.SignatureCalculatorLocalSignatureMatcher;
import org.sidiff.superimposition.signature.ISignatureCalculator;
import org.sidiff.superimposition.signature.impl.DefaultSignatureCalculator;

/**
 * Default {@link ISignatureCalculator} using the qualified name of an {@link EObject}
 *
 * @author cpietsch
 *
 */
public class DefaultSignatureMatcher extends SignatureCalculatorLocalSignatureMatcher {

	@Override
	public String getName() {
		return "Default Signature-based Matcher";
	}

	@Override
	public void createSignatureCalculators(Consumer<ISignatureCalculator> acceptor) {
		acceptor.accept(ISignatureCalculator.MANAGER.getExtension(DefaultSignatureCalculator.class).get());
	}
}
