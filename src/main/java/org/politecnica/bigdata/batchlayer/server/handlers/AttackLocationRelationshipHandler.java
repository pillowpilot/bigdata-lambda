package org.politecnica.bigdata.batchlayer.server.handlers;

import java.io.IOException;

import org.apache.thrift.TException;
import org.politecnica.bigdata.batchlayer.LocalConnectionManager;
import org.politecnica.bigdata.batchlayer.model.AttackAtEdge;
import org.politecnica.bigdata.batchlayer.model.AttackID;
import org.politecnica.bigdata.batchlayer.model.Data;
import org.politecnica.bigdata.batchlayer.model.DataUnit;
import org.politecnica.bigdata.batchlayer.model.LocationID;
import org.politecnica.bigdata.batchlayer.model.Pedigree;
import org.politecnica.bigdata.batchlayer.model.factories.AttackFactory;
import org.politecnica.bigdata.batchlayer.model.factories.LocationFactory;
import org.politecnica.bigdata.batchlayer.server.AttackLocationRelationship.Iface;
import org.politecnica.bigdata.batchlayer.server.storing.DataUnitStorer;

import com.backtype.hadoop.pail.Pail.TypedRecordOutputStream;

public class AttackLocationRelationshipHandler implements Iface {

	@Override
	public void setRelationship(long attack_id, long location_id) throws TException {
		AttackFactory attackFactory = new AttackFactory();
		AttackID attack = attackFactory.build(attack_id);

		LocationFactory locationFactory = new LocationFactory();
		LocationID location = locationFactory.build(location_id);

		AttackAtEdge edge = new AttackAtEdge(attack, location);

		storeEdge(edge);
	}

	private void storeEdge(AttackAtEdge edge) {
		DataUnit edgeDataUnit = new DataUnit();
		edgeDataUnit.setAttack_at_edge(edge);

		DataUnitStorer storer = new DataUnitStorer();
		storer.store(edgeDataUnit);
	}
}
