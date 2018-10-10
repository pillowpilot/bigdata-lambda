package org.politecnica.bigdata.servinglayer.batchqueries;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Paths;
import org.apache.thrift.TFieldIdEnum;
import org.politecnica.bigdata.batchlayer.DataPailStructure;
import org.politecnica.bigdata.batchlayer.model.AttackProperty;
import org.politecnica.bigdata.batchlayer.model.Data;
import org.politecnica.bigdata.servinglayer.SingleDoubleTap;

import com.backtype.cascading.tap.PailTap;
import com.backtype.cascading.tap.PailTap.PailTapOptions;
import com.backtype.hadoop.pail.PailSpec;
import com.backtype.hadoop.pail.PailStructure;
import cascading.flow.FlowProcess;
import cascading.operation.FunctionCall;
import cascading.tuple.Tuple;
import cascalog.CascalogFunction;
import jcascalog.Api;
import jcascalog.ClojureOp;
import jcascalog.Subquery;

public class NumericDataQueryMaker implements Serializable {
	private static final long serialVersionUID = 1L;
	private String pailFilePath = null;
	private PailTap source = null;
	private PailTapOptions opts = null;
	private CascalogFunction fieldsExtractor = null;
	private final String dataFieldName = "?data";
	private final String numericDataFieldName = "?numericData";
	private final String outputFieldName = "?operatorResult";

	public NumericDataQueryMaker(File rootDirectory, TFieldIdEnum field, CascalogFunction fieldsExtractor)
			throws IOException {
		this.fieldsExtractor = fieldsExtractor;
		pailFilePath = Paths.get(rootDirectory.getAbsolutePath(), "" + field.getThriftFieldId()).toAbsolutePath()
				.toString();

		opts = new PailTapOptions();
		opts.spec = new PailSpec((PailStructure) new DataPailStructure());

		source = new PailTap(pailFilePath, opts);

		CascalogFunction extractor = new CascalogFunction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void operate(FlowProcess process, FunctionCall call) {
				Data data = (Data) call.getArguments().getObject(0);
				AttackProperty attackProperty = data.getDataUnit().getAttack_property();

				if (attackProperty.getProperty().isSetNkills()) {
					call.getOutputCollector().add(new Tuple(attackProperty.getProperty().getNkills()));
				}
			}
		};
	}

	public double getOperatorResult(ClojureOp operator) {
		SingleDoubleTap variableTap = new SingleDoubleTap();
		Api.execute(variableTap,
				new Subquery(outputFieldName).predicate(source, "_", dataFieldName)
						.predicate(fieldsExtractor, dataFieldName).out(numericDataFieldName)
						.predicate(operator, numericDataFieldName).out(outputFieldName));
		return variableTap.getValue();
	}

	public double getMinValue() {
		return getOperatorResult(new jcascalog.op.Min());
	}

	public double getMaxValue() {
		return getOperatorResult(new jcascalog.op.Max());
	}

	public double getAverageValue() {
		return getOperatorResult(new jcascalog.op.Avg());
	}

	public double getSumValue() {
		return getOperatorResult(new jcascalog.op.Sum());
	}

	public double getCount() {
		final String indicatorFieldName = "?indicator";
		SingleDoubleTap variableTap = new SingleDoubleTap();

//		Api.execute(variableTap,
//				new Subquery(indicatorFieldName).predicate(source, "_", dataFieldName)
//						.predicate(fieldsExtractor, dataFieldName).out(numericDataFieldName)
//						.predicate(new Counter(), numericDataFieldName).out(indicatorFieldName));
//		return variableTap.getValue();
		return 0.0;
	}
}
