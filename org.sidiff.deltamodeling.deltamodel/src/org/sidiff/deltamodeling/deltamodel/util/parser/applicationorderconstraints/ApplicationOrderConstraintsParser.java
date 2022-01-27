package org.sidiff.deltamodeling.deltamodel.util.parser.applicationorderconstraints;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.sidiff.deltamodeling.deltamodel.ConstraintGroup;
import org.sidiff.deltamodeling.deltamodel.DeltaModelFactory;
import org.sidiff.deltamodeling.deltamodel.DeltaModule;
import org.sidiff.deltamodeling.deltamodel.DeltaModuleSet;
import org.sidiff.deltamodeling.deltamodel.util.parser.applicationorderconstraints.exception.InvalidApplicationOrderConstraintsException;
import org.sidiff.formula.parser.Tokenizer;

/**
 * <pre>
 * &lt;applicationOrderConstraints> ::= { &lt;constraintGroup> }
 * &lt;constraintGroup> ::= '[' &lt;constraint> { ',' &lt;constraint> } ']'
 * &lt;constraint ::= &lt;letter> { &lt;letter> | &lt;digit> }
 * &lt;letter>      ::= 'A' | ... | 'z' | 'a' | ... | 'z'
 * &lt;digit>       ::= '0' | ... | '9'
 * @author cpietsch
 *
 */
public class ApplicationOrderConstraintsParser {

	/**
	 * The singleton instance
	 */
	public static final ApplicationOrderConstraintsParser INSTANCE = new ApplicationOrderConstraintsParser();
	
	private static final String BRACELEFT = "[";
	private static final String BRACERIGHT = "]";
	private static final String COMMA = ",";
	
	private DeltaModuleSet deltaModuleSet;
	
	private ApplicationOrderConstraintsParser() {
		// singleton constructor
	}
	
	private List<ConstraintGroup> applicationOrderConstraints(Tokenizer<String> tokenizer) throws InvalidApplicationOrderConstraintsException {
		List<ConstraintGroup> constraintGroups = new ArrayList<ConstraintGroup>();
		while(tokenizer.hasNext()) {
			ConstraintGroup group = constraintGroup(tokenizer);
			constraintGroups.add(group);
		}
		return constraintGroups;
	}

	private ConstraintGroup constraintGroup(Tokenizer<String> tokenizer) throws InvalidApplicationOrderConstraintsException {
		if(tokenizer.hasNext() && tokenizer.peek().equals(BRACELEFT)) {
			tokenizer.next();
			List<DeltaModule> constraints = new ArrayList<DeltaModule>();
			constraints.add(constraint(tokenizer));
			while(tokenizer.hasNext() && tokenizer.peek().equals(COMMA)) {
				tokenizer.next();
				constraints.add(constraint(tokenizer));
			}
			
			if(tokenizer.hasNext() && tokenizer.peek().equals(BRACERIGHT)) {
				tokenizer.next();
			}else {
				throw new InvalidApplicationOrderConstraintsException("Missing '" + COMMA + "' or '" + BRACERIGHT + "'");
			}
			
			ConstraintGroup constraintGroup = DeltaModelFactory.eINSTANCE.createConstraintGroup();
			constraintGroup.getDeltaModules().addAll(constraints);
			return constraintGroup;
			
		}else {
			throw new InvalidApplicationOrderConstraintsException("Missing '" + BRACELEFT + "'");
		}
	}

	private DeltaModule constraint(Tokenizer<String> tokenizer) throws InvalidApplicationOrderConstraintsException {

		if(tokenizer.hasNext()) {
			DeltaModule constraint = deltaModuleSet.getDeltaModule(tokenizer.next());
			if(constraint != null) {
				return constraint;
			}
		}
			
		throw new InvalidApplicationOrderConstraintsException("Delta Module expected");
		
	}
	
	public List<ConstraintGroup> parse(String s, DeltaModuleSet deltaModuleSet) throws InvalidApplicationOrderConstraintsException {
		this.deltaModuleSet = deltaModuleSet;
		String expression = s.replaceAll("\\s*\\[\\s*", " [ ");
		expression = expression.replaceAll("\\s*\\]\\s*", " ] ");
		expression = expression.replaceAll("\\s*,\\s*", " , ");
		expression = expression.trim();
		expression = expression.replaceAll("\\s+", ":");
		// the tokenizer is passed by argument to allow this class to be immutable
		Tokenizer<String> tokenizer = new Tokenizer<>(expression.split(":"));
		List<ConstraintGroup> applicationOrderConstraints = this.applicationOrderConstraints(tokenizer);
		
		if(tokenizer.hasNext()) {
			throw new InvalidApplicationOrderConstraintsException("'[' instead of " + tokenizer.next() + " expected");
		}
		return applicationOrderConstraints;
	}
	
	public String unparse(List<ConstraintGroup> constraintGroups) {
		StringBuilder builder = new StringBuilder();
		for(ConstraintGroup constraintGroup : constraintGroups) {
			builder.append("[");
			for (Iterator<DeltaModule> iterator = constraintGroup.getDeltaModules().iterator(); iterator.hasNext();) {
				DeltaModule deltaModule = iterator.next();
				builder.append(deltaModule.getName());
				if(iterator.hasNext()) {
					builder.append(", ");
				}
			}
			builder.append("]");
		}
		
		return builder.toString();
	}
}
