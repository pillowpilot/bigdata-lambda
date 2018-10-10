package org.politecnica.bigdata.batchlayer;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.thrift.TBase;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.TUnion;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.StructMetaData;
import org.politecnica.bigdata.batchlayer.model.AttackProperty;
import org.politecnica.bigdata.batchlayer.model.AttackPropertyValue;

public class PropertyStructure implements FieldStructure {
	private TFieldIdEnum valueId;
	private HashSet<Short> validIds;

	public PropertyStructure(Class property) {
		try {
			Map<TFieldIdEnum, FieldMetaData> propertyMetadata = getMetadataMap(property);
			Class valueClass = Class.forName(property.getName() + "Value");
			valueId = getIdForClass(propertyMetadata, valueClass);

			validIds = new HashSet<Short>();
			Map<TFieldIdEnum, FieldMetaData> valueMetadata = getMetadataMap(valueClass);
			for (TFieldIdEnum valId : valueMetadata.keySet()) {
				validIds.add(valId.getThriftFieldId());
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	private static Map<TFieldIdEnum, FieldMetaData> getMetadataMap(Class property) {
		try {
			Object o = property.newInstance();
			return (Map) property.getField("metaDataMap").get(o);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	private static TFieldIdEnum getIdForClass(Map<TFieldIdEnum, FieldMetaData> metadatas, Class toFind) {
		TFieldIdEnum searchResult = null;
		for (TFieldIdEnum key : metadatas.keySet()) {
			FieldValueMetaData metadata = metadatas.get(key).valueMetaData;
			if (metadata instanceof StructMetaData)
				if (toFind.equals(((StructMetaData) metadata).structClass)) {
					searchResult = key;
				}
		}
		if (searchResult == null)
			throw new RuntimeException("Could not find " + toFind.toString() + " in " + metadatas.toString());
		else
			return searchResult;
	}

	@Override
	public boolean isValidTarget(String[] dirs) {
		if (dirs.length < 2)
			return false;
		try {
			short propertyValueId = Short.parseShort(dirs[2]);
			return validIds.contains(propertyValueId);
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	@Override
	public void fillTarget(List<String> ret, Object val) {
		ret.add("" + ((TUnion) ((TBase) val).getFieldValue(valueId)).getSetField().getThriftFieldId());
	}

}
