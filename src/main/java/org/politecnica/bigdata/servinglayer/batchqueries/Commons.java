package org.politecnica.bigdata.servinglayer.batchqueries;

import java.util.ArrayList;
import java.util.List;

import org.politecnica.bigdata.batchlayer.model.DataUnit;

import com.backtype.cascading.tap.PailTap;

public class Commons {
	public static PailTap attributeTap(String path, final DataUnit._Fields... fields)
	{
		PailTap.PailTapOptions opts = new PailTap.PailTapOptions();
		opts.attrs = new List[] {
				new ArrayList<String>() {{
					for(DataUnit._Fields field: fields)
					{
						add("" + field.getThriftFieldId());
					}
				}}
		};
		return new PailTap(path, opts);
	}
}
