package org.politecnica.bigdata.batchlayer.model.factories;

import org.politecnica.bigdata.batchlayer.model.AttackID;

public class AttackFactory implements Factory<AttackID> {

	@Override
	public AttackID build(long id) {
		AttackID attack = new AttackID();
		attack.setId(id);
		return attack;
	}
}
