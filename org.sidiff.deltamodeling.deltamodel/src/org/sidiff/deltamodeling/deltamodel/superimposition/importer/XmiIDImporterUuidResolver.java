package org.sidiff.deltamodeling.deltamodel.superimposition.importer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.entities.Element;
import org.sidiff.entities.IdentifiableEntity;
import org.sidiff.entities.importer.uuid.IImporterUuidResolver;

public class XmiIDImporterUuidResolver implements IImporterUuidResolver {

	Map<String,IdentifiableEntity> uuidIndex = new HashMap<String, IdentifiableEntity>();
	
	
	@Override
	public String computeUuid(IdentifiableEntity entity) {
		String xmiId = null;
		if(entity instanceof Element) {
			xmiId = EMFUtil.getXmiId(((Element)entity).getObject());
		}
		
		if(xmiId == null || uuidIndex.keySet().contains(xmiId)) {
			xmiId = EcoreUtil.generateUUID();
			if(entity instanceof Element && !((Element)entity).isExternal()) {
				EMFUtil.setXmiId(((Element)entity).getObject(), xmiId);
			}
		}
		return xmiId;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void init(Collection<Object> arguments) {
		boolean initialized = false;
		if(arguments.size() == 1) {
			Object firstArgument = arguments.iterator().next();
			if(firstArgument instanceof Map<?, ?>) {
				this.uuidIndex = (Map<String, IdentifiableEntity>) firstArgument;
				initialized = true;
			}
		}

		if(!initialized){
			throw new RuntimeException("Wrong arguments: Map with typeparameters <String, IdentifiableEntity> expected!");
		}
		
	}
}
