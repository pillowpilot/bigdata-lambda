package org.politecnica.bigdata.servinglayer;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.apache.hadoop.hbase.client.Table;
import org.apache.thrift.TFieldIdEnum;
import org.politecnica.bigdata.batchlayer.HDFSConnectionManager;
import org.politecnica.bigdata.batchlayer.model.AttackProperty;
import org.politecnica.bigdata.batchlayer.model.Data;
import org.politecnica.bigdata.batchlayer.model.DataUnit;
import org.politecnica.bigdata.servinglayer.batchqueries.AttackNumberOfKillsUpdater;
import org.politecnica.bigdata.servinglayer.batchqueries.NumericDataQueryMaker;

import cascading.flow.FlowProcess;
import cascading.operation.FunctionCall;
import cascading.tuple.Tuple;
import cascalog.CascalogFunction;

public class BatchViewsUpdater {
	public static void main(String[] args) throws IOException, URISyntaxException {
		DatabaseInitializer initializer = new DatabaseInitializer();
		initializer.initialize();
		
		System.out.println("Connection to HBase completed");
		
		Configuration configuration = new Configuration();
		FileSystem filesystem = FileSystem.get(new URI(HDFSConnectionManager.defaultUri), configuration);
		RemoteIterator<LocatedFileStatus> fileStatusListIterator = 
				filesystem.listLocatedStatus(new Path("/user/federico/data/"));
		while(fileStatusListIterator.hasNext())
		{
			LocatedFileStatus fileStatus = fileStatusListIterator.next();
			if(fileStatus.isDirectory())
			{
				Path filepath = fileStatus.getPath();
				updateNumberOfKills(filepath);
			}
		}
		
		
//		List<File> validDirectories = Commons.getDateDirectories(new File(rootDirectory));
//		
//		for(File validDirectory: validDirectories)
//		{
//			updateNumberOfKills(validDirectory);
//		}
	}

	private static void updateNumberOfKills(Path partitionedDirectory) throws IOException {
		System.out.println("Updating NKills at " + partitionedDirectory);
		
		TFieldIdEnum fieldEnum = DataUnit._Fields.ATTACK_PROPERTY;

		CascalogFunction extractor = new CascalogFunction() {
			@Override
			public void operate(FlowProcess process, FunctionCall call) {
				Data data = (Data) call.getArguments().getObject(0);
				AttackProperty attackProperty = data.getDataUnit().getAttack_property();

				if (attackProperty.getProperty().isSetNkills()) {
					call.getOutputCollector().add(
							new Tuple(attackProperty.getProperty().getNkills()));
				}
			}
		};

		NumericDataQueryMaker queryMaker = new NumericDataQueryMaker(partitionedDirectory, fieldEnum, extractor);
		
		final long minValue = (long) queryMaker.getMinValue();
		final long maxValue = (long) queryMaker.getMaxValue();
		final long sumValue = (long) queryMaker.getSumValue();
		final double localAvgValue = queryMaker.getAverageValue();
		final long countValue = (long) (sumValue / localAvgValue);
		
		System.out.println(minValue);
		System.out.println(maxValue);
		System.out.println(sumValue);
		System.out.println(localAvgValue);
		System.out.println(countValue);
		
		final String dayDescription = partitionedDirectory.getName();
		System.out.println(dayDescription);
		
		Table attackTable = HBaseConnectionManager.getInstance().getTable(Commons.HBaseAttackTableName);
		
		AttackNumberOfKillsUpdater nkillsUpdater = 
				new AttackNumberOfKillsUpdater(attackTable, dayDescription, minValue, maxValue, sumValue, countValue);
		nkillsUpdater.update();
	}
}
