package org.sidiff.deltamodeling.deltamodel.superimposition.signature;

import java.util.function.Consumer;
import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.extension.TypedExtensionManager;
import org.sidiff.matcher.IMatcher;
import org.sidiff.superimposition.signature.ISignatureCalculator;

public interface ISignatureMatcher extends IMatcher {

	Description<ISignatureMatcher> DESCRIPTION = Description.of(ISignatureMatcher.class,
			"org.sidiff.deltamodeling.deltamodel.signature_matcher", "signature_matcher", "class");
	TypedExtensionManager<ISignatureMatcher> MANAGER = new TypedExtensionManager<>(DESCRIPTION);

	void setSignatureCalculator(Function<EObject,String> signatureCalculator);
	void createSignatureCalculators(Consumer<ISignatureCalculator> acceptor);
}
