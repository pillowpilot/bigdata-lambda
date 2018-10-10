package org.politecnica.bigdata.batchlayer.server.handlers;

import java.io.IOException;

import org.apache.thrift.TException;
import org.politecnica.bigdata.batchlayer.LocalConnectionManager;
import org.politecnica.bigdata.batchlayer.model.Data;
import org.politecnica.bigdata.batchlayer.model.DataUnit;
import org.politecnica.bigdata.batchlayer.model.LocationID;
import org.politecnica.bigdata.batchlayer.model.LocationProperty;
import org.politecnica.bigdata.batchlayer.model.LocationPropertyValue;
import org.politecnica.bigdata.batchlayer.model.Pedigree;
import org.politecnica.bigdata.batchlayer.model.factories.LocationFactory;
import org.politecnica.bigdata.batchlayer.server.LocationProperties.Iface;
import org.politecnica.bigdata.batchlayer.server.storing.DataUnitStorer;

import com.backtype.hadoop.pail.Pail.TypedRecordOutputStream;

public class LocationPropertiesHandler implements Iface {

	@Override
	public void setCity(long id, String cityData) throws TException {
		LocationPropertyValue city = new LocationPropertyValue();
		city.setCity(cityData);

		storeProperty(id, city);
	}

	@Override
	public void setCountry(long id, String countryData) throws TException {
		LocationPropertyValue country = new LocationPropertyValue();
		country.setCountry(countryData);

		storeProperty(id, country);
	}

	@Override
	public void setRegion(long id, String regionData) throws TException {
		LocationPropertyValue region = new LocationPropertyValue();
		region.setCountry(regionData);

		storeProperty(id, region);
	}

	private void storeProperty(long id, LocationPropertyValue propertyValue) {
		LocationFactory locationFactory = new LocationFactory();
		LocationID location = locationFactory.build(id);
		LocationProperty property = new LocationProperty(location, propertyValue);

		DataUnit propertyDataUnit = new DataUnit();
		propertyDataUnit.setLocation_property(property);

		DataUnitStorer storer = new DataUnitStorer();
		storer.store(propertyDataUnit);
	}
}
