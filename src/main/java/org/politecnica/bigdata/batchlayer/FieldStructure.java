package org.politecnica.bigdata.batchlayer;

import java.util.List;

interface FieldStructure {
	public boolean isValidTarget(String[] dirs);

	public void fillTarget(List<String> ret, Object val);
}
