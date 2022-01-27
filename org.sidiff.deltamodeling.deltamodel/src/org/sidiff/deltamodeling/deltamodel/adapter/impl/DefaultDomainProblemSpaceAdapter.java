package org.sidiff.deltamodeling.deltamodel.adapter.impl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.resources.IFile;
import org.sidiff.common.io.IOUtil;
import org.sidiff.deltamodeling.deltamodel.adapter.IDomainProblemSpaceAdapter;
import org.sidiff.formula.Formula;
import org.sidiff.formula.parser.FormulaParser;

/**
 * 
 * @author cpietsch
 *
 */
public class DefaultDomainProblemSpaceAdapter implements IDomainProblemSpaceAdapter {

	public DefaultDomainProblemSpaceAdapter() {
	}

	@Override
	public Set<String> getFileExtensions() {
		// Although this supports every file, selecting a txt file should prefer this adapter
		return Stream.of("txt", WILDCARD).collect(Collectors.toSet());
	}

	@Override
	public Formula generateFormula(IFile file) throws Exception {
		try (InputStream inStream = file.getContents();
				ByteArrayOutputStream outStream = new ByteArrayOutputStream()) {
			IOUtil.transfer(inStream, outStream);
			return FormulaParser.INSTANCE.parse(outStream.toString(file.getCharset()));
		}
	}

	@Override
	public String getKey() {
		return getClass().getName();
	}

	@Override
	public String getName() {
		return "Default domain problem space adapter";
	}
}
