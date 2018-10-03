include "models.thrift"

namespace java org.politecnica.bigdata.batchlayer.server

service AttackProperties
{
	void setNumberOfKills(1: i64 id, 2: i64 nkills),
	void setDate(1: i64 id, 2: i64 day, 3: i64 month, 4: i64 year),
	void setCoordinates(1: i64 id, 2: double latitude, 3: double longitude)
}

service WeaponProperties
{
	void setDescription(1: i64 id, 2: string description)
}

service LocationProperties
{
	void setCity(1: i64 id, 2: string city),
	void setCountry(1: i64 id, 2: string country),
	void setRegion(1: i64 id, 2: string region)
}

service AttackLocationRelationship
{
	void setRelationship(1: i64 attack_id, 2: i64 location_id)
}

service AttackWeaponRelationship
{
	void setRelationship(1: i64 attack_id, 2: i64 weapon_id)
}