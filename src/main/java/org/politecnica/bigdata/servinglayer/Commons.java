package org.politecnica.bigdata.servinglayer;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hbase.TableName;
import org.politecnica.bigdata.batchlayer.DataPailStructure;
import org.politecnica.bigdata.batchlayer.model.DataUnit;

import com.backtype.cascading.tap.PailTap;

public class Commons {
	public static String HBaseAttackTableName = "attack";
	public static String HBaseTableNumberOfKillsColumnName = "numberOfKills";
	public static String HBaseTableWeaponDescriptionColumnName = "weaponDescription";

	public static PailTap attributeTap(String path, final DataUnit._Fields... fields) {
		PailTap.PailTapOptions opts = new PailTap.PailTapOptions();
		opts.attrs = new List[] { new ArrayList<String>() {
			{
				for (DataUnit._Fields field : fields) {
					add("" + field.getThriftFieldId());
				}
			}
		} };
		return new PailTap(path, opts);
	}

	public static List<File> getDateDirectories(File rootDirectory) {
		SimpleDateFormat formatter = new SimpleDateFormat(DataPailStructure.dateFormat);
		formatter.setLenient(false);

		List<File> validDirectories = new ArrayList<>();
		for (File file : rootDirectory.listFiles()) {
			if (file.isDirectory()) {
				String directoryName = file.getName();
				try {
					formatter.parse(directoryName.trim());
					validDirectories.add(file);
				} catch (ParseException ex) {
				}
			}
		}

		return validDirectories;
	}
}
