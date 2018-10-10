package org.politecnica.bigdata.servinglayer;

import org.apache.hadoop.mapred.JobConf;

import com.twitter.maple.tap.StdoutTap;

import cascading.flow.hadoop.HadoopFlowProcess;
import cascading.tuple.TupleEntryIterator;

public class SingleDoubleTap extends StdoutTap {
	private Double value;
	
	@Override
	public boolean commitResource(JobConf conf) throws java.io.IOException {
		TupleEntryIterator it = new HadoopFlowProcess(conf).openTapForRead(this);
		while (it.hasNext()) {
			value = Double.parseDouble(it.next().getTuple().toString());
		}
		it.close();
		return true;
	}
	
	public Double getValue()
	{
		return value;
	}
}
