package org.politecnica.bigdata.batchlayer.server.handlers;

import java.io.IOException;

import org.apache.thrift.TException;
import org.politecnica.bigdata.batchlayer.LocalConnectionManager;
import org.politecnica.bigdata.batchlayer.model.Data;
import org.politecnica.bigdata.batchlayer.model.DataUnit;
import org.politecnica.bigdata.batchlayer.model.Pedigree;
import org.politecnica.bigdata.batchlayer.model.WeaponID;
import org.politecnica.bigdata.batchlayer.model.WeaponProperty;
import org.politecnica.bigdata.batchlayer.model.WeaponPropertyValue;
import org.politecnica.bigdata.batchlayer.model.factories.WeaponFactory;
import org.politecnica.bigdata.batchlayer.server.WeaponProperties.Iface;
import org.politecnica.bigdata.batchlayer.server.storing.DataUnitStorer;

import com.backtype.hadoop.pail.Pail.TypedRecordOutputStream;

public class WeaponPropertiesHandler implements Iface {

	@Override
	public void setDescription(long id, String descriptionData) throws TException {
		WeaponPropertyValue description = new WeaponPropertyValue();
		description.setDescription(descriptionData);

		storeProperty(id, description);
	}

	private void storeProperty(long id, WeaponPropertyValue propertyValue) {
		WeaponFactory weaponFactory = new WeaponFactory();
		WeaponID weapon = weaponFactory.build(id);
		WeaponProperty property = new WeaponProperty(weapon, propertyValue);

		DataUnit propertyDataUnit = new DataUnit();
		propertyDataUnit.setWeapon_property(property);

		DataUnitStorer storer = new DataUnitStorer();
		storer.store(propertyDataUnit);
	}
}
