package org.politecnica.bigdata.servinglayer.batchqueries;

import cascading.tap.Tap;
import cascading.tuple.Tuple;
import cascalog.CascalogFunction;
import jcascalog.Api;
import jcascalog.Subquery;
import jcascalog.op.Avg;
import jcascalog.op.Max;
import jcascalog.op.Min;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.politecnica.bigdata.batchlayer.DataPailStructure;
import org.politecnica.bigdata.batchlayer.LocalConnectionManager;
import org.politecnica.bigdata.batchlayer.model.AttackProperty;
import org.politecnica.bigdata.batchlayer.model.Data;
import org.politecnica.bigdata.batchlayer.model.DataUnit;
import org.politecnica.bigdata.servinglayer.Commons;

import com.backtype.hadoop.pail.PailSpec;
import com.backtype.hadoop.pail.PailStructure;
import com.twitter.maple.tap.StdoutTap;
import com.backtype.cascading.tap.PailTap;
import com.backtype.cascading.tap.PailTap.PailTapOptions;

import cascading.flow.FlowProcess;
import cascading.operation.FunctionCall;
import cascading.tap.SourceTap;

public class MinQueryMakerold {
	public MinQueryMakerold() throws IOException {
		LocalConnectionManager instance = LocalConnectionManager.getInstance();
		final String pailDirpath = "/home/federico/bigdata/pail/test1538495084016/2018-10-02/1/";

		String path = "/home/federico/bigdata/pail/test1538495084016";
		System.out.println(instance.getPath());
		System.out.println(path);
		List<File> dirs = Commons.getDateDirectories(new File(path));
		System.out.println(dirs);

		PailTap source = null;

		PailTapOptions opts = new PailTapOptions();
		opts.spec = new PailSpec((PailStructure) new DataPailStructure());

		source = new PailTap(pailDirpath, opts);

		System.out.println(source);

		Api.execute(new StdoutTap(),
				new Subquery("?avg_nkills").predicate(source, "_", "?data").predicate(new ExtractFields(), "?data")
						.out("?id", "?nkills").predicate(new Avg(), "?nkills").out("?avg_nkills"));

		Api.execute(new StdoutTap(),
				new Subquery("?min_nkills").predicate(source, "_", "?data").predicate(new ExtractFields(), "?data")
						.out("?id", "?nkills").predicate(new Min(), "?nkills").out("?min_nkills"));

		Api.execute(new StdoutTap(),
				new Subquery("?max_nkills").predicate(source, "_", "?data").predicate(new ExtractFields(), "?data")
						.out("?id", "?nkills").predicate(new Max(), "?nkills").out("?max_nkills"));

	}

	public static void main(String[] args) throws IOException {
		MinQueryMakerold qm = new MinQueryMakerold();

	}

	public static class ExtractFields extends CascalogFunction {
		public void operate(FlowProcess process, FunctionCall call) {
			Data data = (Data) call.getArguments().getObject(0);
			AttackProperty attackProperty = data.getDataUnit().getAttack_property();

			if (attackProperty.getProperty().isSetNkills()) {
				call.getOutputCollector()
						.add(new Tuple(attackProperty.getAttack().getId(), attackProperty.getProperty().getNkills()));
			}
		}
	}
}
