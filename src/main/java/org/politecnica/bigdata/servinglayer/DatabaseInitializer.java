package org.politecnica.bigdata.servinglayer;

import java.io.IOException;

import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;

public class DatabaseInitializer {
	public void initialize() throws IOException {
		HBaseConnectionManager hbConnManager = HBaseConnectionManager.getInstance();
		Admin admin = hbConnManager.getAdmin();

		HTableDescriptor descriptor = new HTableDescriptor(TableName.valueOf(Commons.HBaseAttackTableName));
		if (admin.tableExists(descriptor.getTableName())) {
			admin.disableTable(descriptor.getTableName());
			admin.deleteTable(descriptor.getTableName());
		}
		descriptor.addFamily(new HColumnDescriptor(Commons.HBaseTableNumberOfKillsColumnName));
		descriptor.addFamily(new HColumnDescriptor(Commons.HBaseTableWeaponDescriptionColumnName));
		admin.createTable(descriptor);
	}
}
