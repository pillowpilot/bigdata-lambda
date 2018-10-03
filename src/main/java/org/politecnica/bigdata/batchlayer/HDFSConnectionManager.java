package org.politecnica.bigdata.batchlayer;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.politecnica.bigdata.batchlayer.model.Data;

import com.backtype.hadoop.pail.Pail;
import com.backtype.hadoop.pail.Pail.TypedRecordOutputStream;

public class HDFSConnectionManager {
	static HDFSConnectionManager instance = null;
	FileSystem filesystem;
	Pail<Data> pail;
	
	static HDFSConnectionManager getInstance() throws IOException, URISyntaxException
	{
		if(instance == null)
			instance = new HDFSConnectionManager();
		return instance;
	}

	public HDFSConnectionManager(String uri, String path) throws IOException, URISyntaxException
	{
		connectToHDFSFilesystem(uri);
    	
		pail = Pail.create(filesystem, path, new DataPailStructure());
	}
	
	public HDFSConnectionManager() throws IOException, URISyntaxException
	{
		this("hdfs://localhost:9000/", "data/");
	}
	
	public TypedRecordOutputStream getOutputStream() throws IOException
	{
		return pail.openWrite();
	}
	
	private void connectToHDFSFilesystem(String uri) throws IOException, URISyntaxException
	{
		Configuration configuration = new Configuration();
		filesystem = FileSystem.get(new URI(uri), configuration);
	}
}
