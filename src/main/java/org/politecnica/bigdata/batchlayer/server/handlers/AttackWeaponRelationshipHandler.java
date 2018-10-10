package org.politecnica.bigdata.batchlayer.server.handlers;

import java.io.IOException;

import org.apache.thrift.TException;
import org.politecnica.bigdata.batchlayer.LocalConnectionManager;
import org.politecnica.bigdata.batchlayer.model.AttackID;
import org.politecnica.bigdata.batchlayer.model.Data;
import org.politecnica.bigdata.batchlayer.model.DataUnit;
import org.politecnica.bigdata.batchlayer.model.Pedigree;
import org.politecnica.bigdata.batchlayer.model.WeaponID;
import org.politecnica.bigdata.batchlayer.model.WeaponUsedEdge;
import org.politecnica.bigdata.batchlayer.model.factories.AttackFactory;
import org.politecnica.bigdata.batchlayer.model.factories.WeaponFactory;
import org.politecnica.bigdata.batchlayer.server.AttackWeaponRelationship.Iface;
import org.politecnica.bigdata.batchlayer.server.storing.DataUnitStorer;

import com.backtype.hadoop.pail.Pail.TypedRecordOutputStream;

public class AttackWeaponRelationshipHandler implements Iface {

	@Override
	public void setRelationship(long attack_id, long weapon_id) throws TException {
		AttackFactory attackFactory = new AttackFactory();
		AttackID attack = attackFactory.build(attack_id);

		WeaponFactory weaponFactory = new WeaponFactory();
		WeaponID weapon = weaponFactory.build(weapon_id);

		WeaponUsedEdge edge = new WeaponUsedEdge(attack, weapon);

		storeEdge(edge);
	}

	private void storeEdge(WeaponUsedEdge edge) {
		DataUnit edgeDataUnit = new DataUnit();
		edgeDataUnit.setWeapon_used_edge(edge);

		DataUnitStorer storer = new DataUnitStorer();
		storer.store(edgeDataUnit);
	}
}
