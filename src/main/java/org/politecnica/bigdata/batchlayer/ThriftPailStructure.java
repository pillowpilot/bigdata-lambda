package org.politecnica.bigdata.batchlayer;

import org.apache.thrift.TBase;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;

import com.backtype.hadoop.pail.PailStructure;

public abstract class ThriftPailStructure<T extends Comparable> implements PailStructure<T> {
	private transient TSerializer serializer;
	private transient TDeserializer deserializer;

	private TSerializer getSerializer() {
		if (serializer == null)
			serializer = new TSerializer();
		return serializer;
	}

	private TDeserializer getDeserializer() {
		if (deserializer == null)
			deserializer = new TDeserializer();
		return deserializer;
	}

	public byte[] serialize(T object) {
		try {
			return getSerializer().serialize((TBase) object);
		} catch (TException ex) {
			throw new RuntimeException(ex);
		}
	}

	public T deserialize(byte[] data) {
		T object = createThriftObject();
		try {
			getDeserializer().deserialize((TBase) object, data);
			return object;
		} catch (TException ex) {
			throw new RuntimeException(ex);
		}
	}

	protected abstract T createThriftObject(); // Method to be implemented by childs
}
