package org.politecnica.bigdata.batchlayer;

import org.politecnica.bigdata.batchlayer.model.Data;
import org.politecnica.bigdata.batchlayer.model.DataUnit;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.StructMetaData;

public class DataPailStructure extends ThriftPailStructure<Data> {
	
	private static Map<Short, FieldStructure> validFieldMap = new HashMap<>();
	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	static 
	{
		for(DataUnit._Fields k: DataUnit.metaDataMap.keySet())
		{
			FieldValueMetaData metadata = DataUnit.metaDataMap.get(k).valueMetaData;
			FieldStructure fieldStructure;
			if(metadata instanceof StructMetaData && 
					((StructMetaData) metadata).structClass.getName().endsWith("Property"))
			{
				fieldStructure = new PropertyStructure(((StructMetaData) metadata).structClass);
			}
			else
			{
				fieldStructure = new EdgeStructure();
			}
			validFieldMap.put(k.getThriftFieldId(), fieldStructure);
		}
	}

	@Override
	public boolean isValidTarget(String... dirs) {
		if(dirs.length == 0) 
			return false;
		try
		{
			short id = Short.parseShort(dirs[1]);
			FieldStructure fieldStructure = validFieldMap.get(id);
			if( fieldStructure == null )
			{
				return false;
			}
			else
			{
				return fieldStructure.isValidTarget(dirs);
			}
		}
		catch(NumberFormatException ex)
		{
			return false;
		}
	}

	@Override
	public List<String> getTarget(Data object) {		
		List<String> ret = new ArrayList<>();
		// Add timestamp partition
		
		final long timestamp = object.getPedigree().timestamp;
		final String dateDirectoryName = formatter.format(new Date(timestamp));
		ret.add(dateDirectoryName);
		
		DataUnit dataUnit = object.getDataUnit();
		short id = dataUnit.getSetField().getThriftFieldId();
		ret.add("" + id);
		validFieldMap.get(id).fillTarget(ret, dataUnit.getFieldValue());
		
		System.out.println(ret);
		
		return ret;
	}

	@Override
	public Class getType() {
		return DataPailStructure.class;
	}

	@Override
	protected Data createThriftObject() {
		return new Data();
	}

}
