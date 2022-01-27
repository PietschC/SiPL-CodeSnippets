package org.sidiff.deltamodeling.deltamodel.adapter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.sidiff.common.extension.ExtensionManager;
import org.sidiff.common.extension.IExtension.Description;

/**
 * An {@link ExtensionManager} for adding arbitrary
 * {@link IDomainProblemSpaceAdapter}.
 * 
 * @author cpietsch
 *
 */
public class DomainProblemSpaceAdapterExtensionManager extends ExtensionManager<IDomainProblemSpaceAdapter> {

	public DomainProblemSpaceAdapterExtensionManager(Description<? extends IDomainProblemSpaceAdapter> description) {
		super(description);
	}

	public List<IDomainProblemSpaceAdapter> getAdapters(String fileExtension) {
		List<IDomainProblemSpaceAdapter> adapters = getSortedExtensions();
		return Stream.concat(
					adapters.stream().filter(adapter -> adapter.getFileExtensions().contains(fileExtension)),
					adapters.stream().filter(adapter -> adapter.getFileExtensions().contains(IDomainProblemSpaceAdapter.WILDCARD)))
				.distinct()
				.collect(Collectors.toList());
	}

	public String[] getSupportedFileExtensions() {
		Set<String> fileExtensions = new HashSet<>();
		for(IDomainProblemSpaceAdapter adapter : getExtensions()) {
			fileExtensions.addAll(adapter.getFileExtensions());
		}
		return fileExtensions.toArray(new String[]{});
	}
}
