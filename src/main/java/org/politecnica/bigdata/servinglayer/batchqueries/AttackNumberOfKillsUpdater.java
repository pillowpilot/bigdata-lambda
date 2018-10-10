package org.politecnica.bigdata.servinglayer.batchqueries;

import java.io.IOException;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.politecnica.bigdata.servinglayer.Commons;

public class AttackNumberOfKillsUpdater {
	private Table table;
	private String dayDescription;
	private long minValue;
	private long maxValue;
	private long sumValue;
	private long countValue;

	public AttackNumberOfKillsUpdater(Table table, String dayDescription, long min, long max, long sum, long count) {
		this.table = table;
		this.dayDescription = dayDescription;
		minValue = min;
		maxValue = max;
		sumValue = sum;
		countValue = count;
	}

	public void update() throws IOException {
		updateMin();
		updateMax();
		updateSum();
		updateCount();
	}

	private void updateTemplate(long value, String columnAttribute) throws IOException {
		// TODO Factorize columnAttribute string into commons or a dedicated string holding class
		Put put = new Put(Bytes.toBytes(dayDescription));
		put.addColumn(Bytes.toBytes(Commons.HBaseTableNumberOfKillsColumnName), Bytes.toBytes(columnAttribute),
				Bytes.toBytes(value));
		table.put(put);
	}

	private void updateMin() throws IOException {
		
		updateTemplate(minValue, "min");
	}

	private void updateMax() throws IOException {
		updateTemplate(maxValue, "max");
	}

	private void updateSum() throws IOException {
		updateTemplate(sumValue, "sum");
	}

	private void updateCount() throws IOException {
		updateTemplate(countValue, "count");
	}
}
