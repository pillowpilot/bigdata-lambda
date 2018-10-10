package org.politecnica.bigdata.servinglayer.batchqueries;

import cascading.flow.FlowProcess;
import cascading.operation.Aggregator;
import cascading.operation.AggregatorCall;
import cascading.operation.BaseOperation;
import cascading.tuple.Tuple;
import cascading.tuple.TupleEntry;

public class Counter extends BaseOperation<Counter.Context> implements Aggregator<Counter.Context> {
	public class Context {
		Long count;
	}

	@Override
	public void start(FlowProcess flowProcess, AggregatorCall<Context> aggregatorCall) {
		// get the group values for the current grouping
	    TupleEntry group = aggregatorCall.getGroup();

	    // create a new custom context object
	    Context context = new Context();

	    // optionally, populate the context object
	    context.count = 0L;

	    // set the context object
	    aggregatorCall.setContext( context );
	}

	@Override
	public void aggregate(FlowProcess flowProcess, AggregatorCall<Context> aggregatorCall) {
		// get the current argument values
	    TupleEntry arguments = aggregatorCall.getArguments();

	    // get the context for this grouping
	    Context context = aggregatorCall.getContext();

	    // update the context object
	    context.count++;
	}

	@Override
	public void complete(FlowProcess flowProcess, AggregatorCall<Context> aggregatorCall) {
		Context context = aggregatorCall.getContext();

	    // create a Tuple to hold our result values
	    Tuple result = new Tuple();

	    // insert some values into the result Tuple based on the context
	    result.add(context.count);

	    // return the result Tuple
	    aggregatorCall.getOutputCollector().add( result );
	}
}
