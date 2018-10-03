package org.politecnica.bigdata.batchlayer.model.factories;

public interface Factory<T> {
	public T build(long id);
}
