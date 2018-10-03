package org.politecnica.bigdata.batchlayer.model.factories;

import org.politecnica.bigdata.batchlayer.model.LocationID;

public class LocationFactory implements Factory<LocationID> {

	@Override
	public LocationID build(long id) 
	{
		LocationID Location = new LocationID();
		Location.setId(id);
		return Location;
	}

}
