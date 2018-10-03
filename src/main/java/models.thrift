namespace java org.politecnica.bigdata.batchlayer.model

struct Data
{
  1: required Pedigree pedigree;
  2: required DataUnit dataUnit;
}

struct Pedigree
{
  1: i64 timestamp;
}

union DataUnit
{
  1: AttackProperty attack_property;
  2: WeaponProperty weapon_property;
  3: LocationProperty location_property;
  4: AttackAtEdge attack_at_edge;
  5: WeaponUsedEdge weapon_used_edge;
}

// Nodes
union AttackID
{
  1: i64 id;
}

union LocationID
{
  1: i64 id;
}

union WeaponID
{
  1: i64 id;
}

// Properties
struct AttackProperty
{
  1: required AttackID attack;
  2: required AttackPropertyValue property;
}

union AttackPropertyValue
{
  1: Date date;
  2: Coordinates coordinates;
  3: i64 nkills;
}

struct Date
{
  1: i64 day;
  2: i64 month;
  3: i64 year;
}

struct Coordinates
{
  1: double longitude;
  2: double latitude;
}

struct WeaponProperty
{
  1: required WeaponID weapon;
  2: required WeaponPropertyValue property;
}

union WeaponPropertyValue
{
  1: string description;
}

struct LocationProperty
{
  1: required LocationID location;
  2: required LocationPropertyValue property;
}

union LocationPropertyValue
{
  1: string city;
  2: string country;
  3: string region;
}

// Edges
struct AttackAtEdge
{
  1: required AttackID attack;
  2: required LocationID location;
}

struct WeaponUsedEdge
{
  1: required AttackID attack;
  2: required WeaponID weapon;
}
