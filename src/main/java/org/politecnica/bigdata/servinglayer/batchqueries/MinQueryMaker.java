package org.politecnica.bigdata.servinglayer.batchqueries;

import cascading.tap.Tap;
import cascading.tuple.Tuple;
import cascalog.CascalogFunction;
import jcascalog.Api;
import jcascalog.Subquery;
import jcascalog.op.Avg;
import jcascalog.op.Max;
import jcascalog.op.Min;

import java.io.IOException;

import org.politecnica.bigdata.batchlayer.DataPailStructure;
import org.politecnica.bigdata.batchlayer.LocalConnectionManager;
import org.politecnica.bigdata.batchlayer.model.AttackProperty;
import org.politecnica.bigdata.batchlayer.model.Data;
import org.politecnica.bigdata.batchlayer.model.DataUnit;

import com.backtype.hadoop.pail.PailSpec;
import com.backtype.hadoop.pail.PailStructure;
import com.twitter.maple.tap.StdoutTap;
import com.backtype.cascading.tap.PailTap;
import com.backtype.cascading.tap.PailTap.PailTapOptions;

import cascading.flow.FlowProcess;
import cascading.operation.FunctionCall;
import cascading.tap.SourceTap;

public class MinQueryMaker {
	public MinQueryMaker() throws IOException
	{
		LocalConnectionManager instance = LocalConnectionManager.getInstance();
		final String pailDirpath = "/home/federico/bigdata/pail/test1538495084016/2018-10-02/1/";
		PailTap source = null;
		
		PailTapOptions opts = new PailTapOptions();
		opts.spec = new PailSpec(
				(PailStructure) new DataPailStructure()
				);
		
		source = new PailTap(pailDirpath, opts);

		
		
		System.out.println(source);
//		Api.execute(new StdoutTap(), 
//				new Subquery("?data")
//				.predicate(source, "_", "?data")
//				);
		
		Api.execute(new StdoutTap(), 
				new Subquery("?id", "?min_nkills", "?avg_nkills", "?max_nkills")
				.predicate(source, "_", "?data")
				.predicate(new ExtractFields(), "?data").out("?id", "?timestamp", "?nkills")
				.predicate(new Min(), "?nkills").out("?min_nkills")
				.predicate(new Avg(), "?nkills").out("?avg_nkills")
				.predicate(new Max(), "?nkills").out("?max_nkills")
				);
		
		
	}
	
	public static void main(String[] args) throws IOException
	{
		MinQueryMaker qm = new MinQueryMaker();
		
	}
	public static class ExtractFields extends CascalogFunction {
        public void operate(FlowProcess process, FunctionCall call) {
            Data data = (Data) call.getArguments().getObject(0);
            //System.out.println(data);
            AttackProperty attackProperty = data.getDataUnit().getAttack_property();
            
            //System.out.println(attackProperty);
            
            if(attackProperty.getProperty().isSetNkills())
            {
            call.getOutputCollector().add(new Tuple(
            		attackProperty.getAttack().getId(),
            		data.getPedigree().getTimestamp(),
            		attackProperty.getProperty().getNkills()
            		));
            }       

//            call.getOutputCollector().add(new Tuple(
//                    factsEdge.get_internetUse().get_id(),
//                    factsEdge.get_individualType().get_id(),
//                    factsEdge.get_geography().get_id(),
//                    factsEdge.get_year(),
//                    factsEdge.get_units(),
//                    data.get_pedigree().get_trueAsOfSecs()
//            ));
        }
    }
}
