package org.politecnica.bigdata.servinglayer;

import org.apache.hadoop.hbase.TableName;

public class Commons {
	public static String HBaseTableName = "terroristAttacks";
	public static TableName HBaseTable = null;
	public static String HBaseTableNumberOfKillsColumnName = "numberOfKills";
	public static String HBaseTableWeaponDescriptionColumnName = "weaponDescription";
	
	static {
		HBaseTable = TableName.valueOf(HBaseTableName);
	}
}
