package org.sidiff.deltamodeling.deltamodel.superimposition.signature.impl;

import java.util.function.Consumer;

import org.sidiff.deltamodeling.deltamodel.superimposition.signature.SignatureCalculatorLocalSignatureMatcher;
import org.sidiff.superimposition.signature.ISignatureCalculator;
import org.sidiff.superimposition.signature.impl.XMIIDSignatureCalculator;

public class XmiIDSignatureMatcher extends SignatureCalculatorLocalSignatureMatcher {

	@Override
	public String getName() {
		return "XMI ID-based Matcher";
	}

	@Override
	public void createSignatureCalculators(Consumer<ISignatureCalculator> acceptor) {
		acceptor.accept(ISignatureCalculator.MANAGER.getExtension(XMIIDSignatureCalculator.class).get());
	}
}
