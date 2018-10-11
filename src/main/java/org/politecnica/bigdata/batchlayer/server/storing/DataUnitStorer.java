package org.politecnica.bigdata.batchlayer.server.storing;

import java.io.IOException;
import java.net.URISyntaxException;

import org.politecnica.bigdata.batchlayer.HDFSConnectionManager;
import org.politecnica.bigdata.batchlayer.LocalConnectionManager;
import org.politecnica.bigdata.batchlayer.model.Data;
import org.politecnica.bigdata.batchlayer.model.DataUnit;
import org.politecnica.bigdata.batchlayer.model.Pedigree;

import com.backtype.hadoop.pail.Pail.TypedRecordOutputStream;

public class DataUnitStorer {
	public DataUnitStorer() {

	}

	public void store(DataUnit dataUnit) {
		Pedigree pedigree = new Pedigree();
		pedigree.setTimestamp(calculateTimestamp());

		Data data = new Data();
		data.setDataUnit(dataUnit);
		data.setPedigree(pedigree);

		System.out.println("Storing: " + data);

		HDFSConnectionManager cm;
		try {
			// cm = LocalConnectionManager.getInstance();
			cm = HDFSConnectionManager.getInstance();
			TypedRecordOutputStream out = cm.getOutputStream();
			out.writeObject(data);
			out.close();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Long calculateTimestamp() {
		return System.currentTimeMillis();
	}
}
