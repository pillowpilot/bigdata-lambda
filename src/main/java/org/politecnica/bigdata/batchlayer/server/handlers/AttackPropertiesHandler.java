package org.politecnica.bigdata.batchlayer.server.handlers;

import java.io.IOException;

import org.apache.thrift.TException;
import org.politecnica.bigdata.batchlayer.LocalConnectionManager;
import org.politecnica.bigdata.batchlayer.model.AttackID;
import org.politecnica.bigdata.batchlayer.model.AttackProperty;
import org.politecnica.bigdata.batchlayer.model.AttackPropertyValue;
import org.politecnica.bigdata.batchlayer.model.Coordinates;
import org.politecnica.bigdata.batchlayer.model.Data;
import org.politecnica.bigdata.batchlayer.model.DataUnit;
import org.politecnica.bigdata.batchlayer.model.Date;
import org.politecnica.bigdata.batchlayer.model.Pedigree;
import org.politecnica.bigdata.batchlayer.model.factories.AttackFactory;
import org.politecnica.bigdata.batchlayer.server.AttackProperties.Iface;
import org.politecnica.bigdata.batchlayer.server.storing.DataUnitStorer;

import com.backtype.hadoop.pail.Pail.TypedRecordOutputStream;

public class AttackPropertiesHandler implements Iface {

	@Override
	public void setNumberOfKills(long id, long nkills) throws TException {
		AttackPropertyValue numberOfKills = new AttackPropertyValue();
		numberOfKills.setNkills(nkills);

		storeProperty(id, numberOfKills);
	}

	@Override
	public void setDate(long id, long day, long month, long year) throws TException {
		Date dateData = new Date(); // Thrift model
		dateData.setDay(day);
		dateData.setMonth(month);
		dateData.setYear(year);

		AttackPropertyValue date = new AttackPropertyValue();
		date.setDate(dateData);

		storeProperty(id, date);
	}

	@Override
	public void setCoordinates(long id, double latitude, double longitude) throws TException {
		Coordinates coordinatesData = new Coordinates(); // Thrift model
		coordinatesData.setLongitude(longitude);
		coordinatesData.setLatitude(latitude);

		AttackPropertyValue coordinates = new AttackPropertyValue();
		coordinates.setCoordinates(coordinatesData);

		storeProperty(id, coordinates);
	}

	private void storeProperty(long id, AttackPropertyValue propertyValue) {
		AttackFactory attackFactory = new AttackFactory();
		AttackID attack = attackFactory.build(id);
		AttackProperty property = new AttackProperty(attack, propertyValue);

		DataUnit propertyDataUnit = new DataUnit();
		propertyDataUnit.setAttack_property(property);

		DataUnitStorer storer = new DataUnitStorer();
		storer.store(propertyDataUnit);
	}
}
