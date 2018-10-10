package org.politecnica.bigdata.servinglayer;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Table;

public class HBaseConnectionManager {
	private static HBaseConnectionManager instance = null;
	private Configuration configuration = null;
	private Connection connection = null;

	static public HBaseConnectionManager getInstance() throws IOException {
		if (instance == null)
			instance = new HBaseConnectionManager();
		return instance;
	}

	private HBaseConnectionManager() throws IOException {
		configuration = HBaseConfiguration.create();
		// configuration.addResource(new
		// Path("/home/federico/bigdata/hbase/hbase-2.0.2/conf", "hbase-site.xml"));
		connection = ConnectionFactory.createConnection(configuration);
	}

	public Admin getAdmin() throws IOException {
		return connection.getAdmin();
	}

	public Table getTable(final String tableName) throws IOException {
		return connection.getTable(TableName.valueOf(tableName));
	}
}
