package org.sidiff.deltamodeling.deltamodel.adapter;

import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.sidiff.common.extension.IExtension;
import org.sidiff.formula.Formula;

/**
 * @author cpietsch
 * 
 * An {@link IDomainProblemSpaceAdapter} is responsible for generating an
 * {@link Formula} from a proprietary variability model.
 *
 */
public interface IDomainProblemSpaceAdapter extends IExtension {

	Description<IDomainProblemSpaceAdapter> DESCRIPTION = Description.of(IDomainProblemSpaceAdapter.class,
			"org.sidiff.deltamodeling.deltamodel.domain_problem_space_adapter", "domain_problem_space_adapter", "class");
	DomainProblemSpaceAdapterExtensionManager MANAGER =
			new DomainProblemSpaceAdapterExtensionManager(DESCRIPTION);

	/**
	 * Constant file extension for adapters that support any file.
	 */
	String WILDCARD = "*";

	/**
	 * Returns the expected file extensions of the variability model.
	 * May contain {@link IDomainProblemSpaceAdapter#WILDCARD}.
	 * 
	 * @return the expected file extensions of the variability model.
	 */
	Set<String> getFileExtensions();

	default boolean supports(String fileExtension) {
		return getFileExtensions().contains(fileExtension) || getFileExtensions().contains(WILDCARD);
	}

	/**
	 * Generates a {@link Formula}.
	 * 
	 * @param file
	 *            the variability model
	 */
	Formula generateFormula(IFile file) throws Exception;
}
