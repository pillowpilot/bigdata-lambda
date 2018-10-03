package org.politecnica.bigdata.servinglayer;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

public class HBaseConnectionManager {
	private Configuration configuration = null;
	private Connection connection = null;
	
	public HBaseConnectionManager() throws IOException
	{
		configuration = HBaseConfiguration.create();
		//configuration.addResource(new Path("/home/federico/bigdata/hbase/hbase-2.0.2/conf", "hbase-site.xml"));
		connection = ConnectionFactory.createConnection(configuration);
	}
	public Admin getAdmin() throws IOException
	{
		return connection.getAdmin();
	}
}
