package org.politecnica.bigdata.batchlayer.model.factories;

import org.politecnica.bigdata.batchlayer.model.WeaponID;

public class WeaponFactory implements Factory<WeaponID> {

	@Override
	public WeaponID build(long id) 
	{
		WeaponID weapon = new WeaponID();
		weapon.setId(id);
		return weapon;
	}

}
