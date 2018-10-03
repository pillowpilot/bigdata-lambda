package org.politecnica.clientside;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.politecnica.bigdata.batchlayer.server.AttackLocationRelationship;
import org.politecnica.bigdata.batchlayer.server.AttackProperties;
import org.politecnica.bigdata.batchlayer.server.AttackWeaponRelationship;
import org.politecnica.bigdata.batchlayer.server.LocationProperties;
import org.politecnica.bigdata.batchlayer.server.WeaponProperties;

public class Client {
	public static void main(String[] args)
	{
		try
		{
			final String datasetPath = "global_terrorism.csv";
			final String address = "localhost";
			final int port = 9090;
			
			System.out.println("Working Directory = " + System.getProperty("user.dir"));
			
			TTransport transport = new TSocket(address, port);
		    transport.open();

		    TProtocol protocol = new  TBinaryProtocol(transport);
		    
		    Reader reader = Files.newBufferedReader(Paths.get(datasetPath), Charset.forName("ISO-8859-1"));
		    CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
		    
		    final int limit = 100;
		    int i = 0;
		    for(CSVRecord record: csvParser)
		    {
		    	if(i == limit)
		    		break;
		    	loadAttackEvent(record, protocol);
		    	++i;
		    }
		    
		    csvParser.close();
		    transport.close();
		}
		catch(TException | IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
	private static void loadAttackEvent(CSVRecord record, TProtocol protocol) throws TException
	{
		final Long attackId = loadAttackProperties(record, protocol);
		final Long locationId = loadLocationProperties(record, protocol);
		final Long weaponId = loadWeaponProperties(record, protocol);
		
		loadAttackLocationRelationship(protocol, attackId, locationId);
		loadAttackWeaponRelationship(protocol, attackId, weaponId);
	}
	private static Long loadAttackProperties(CSVRecord record, TProtocol protocol) throws TException
	{
		final String attackProtocolStringID = "attackProperties";
		TMultiplexedProtocol multiplexedProtocol = new TMultiplexedProtocol(protocol, attackProtocolStringID);
		AttackProperties.Client attackPropertiesClient = new AttackProperties.Client(multiplexedProtocol);
		
		// Get AttackId
		final Long attackId = Long.parseLong(record.get("eventid"));
		
		// Set Coordinates if exists
		final String latitudeColumnName = "latitude";
		final String longitudeColumnName = "longitude";
		if(checkForColumnValue(record, latitudeColumnName) && checkForColumnValue(record, longitudeColumnName))
		{
			final double latitude = Double.parseDouble(record.get(latitudeColumnName));
			final double longitude = Double.parseDouble(record.get(longitudeColumnName));
			attackPropertiesClient.setCoordinates(attackId, latitude, longitude);
		}
		
		// Set Number Of Kills if exists
		final String numberOfKillsColumnName = "nkill";
		if(checkForColumnValue(record, numberOfKillsColumnName))
		{
			final long numberOfKills = Long.parseLong(record.get(numberOfKillsColumnName));
			attackPropertiesClient.setNumberOfKills(attackId, numberOfKills);
		}
		
		// Set Date if exists
		final String dayColumnName = "iday";
		final String monthColumnName = "imonth";
		final String yearColumnName = "iyear";
		if(checkForColumnValue(record, dayColumnName) && checkForColumnValue(record, monthColumnName) &&
				checkForColumnValue(record, yearColumnName))
		{
			final long day = Long.parseLong(record.get(dayColumnName));
			final long month = Long.parseLong(record.get(monthColumnName));
			final long year = Long.parseLong(record.get(yearColumnName));
			attackPropertiesClient.setDate(attackId, day, month, year);
		}
		
		return attackId;
	}
	private static Long loadLocationProperties(CSVRecord record, TProtocol protocol) throws TException
	{
		final String locationProtocolStringID = "locationProperties";
		TMultiplexedProtocol multiplexedProtocol = new TMultiplexedProtocol(protocol, locationProtocolStringID);
		LocationProperties.Client locationPropertiesClient = new LocationProperties.Client(multiplexedProtocol);
		
		// Get LocationId
		final String locationCharacterization = "" + record.get("country") + record.get("region") + record.get("city");
		System.out.println("loc char: " + locationCharacterization + " w/ hc " + locationCharacterization.hashCode());
		final Long locationId = (long) locationCharacterization.hashCode();
		
		// Set Location if exits
		final String cityColumnName = "city";
		if(checkForColumnValue(record, cityColumnName))
		{
			final String city = record.get(cityColumnName);
			locationPropertiesClient.setCity(locationId, city);
		}
		
		// Set Country if exists
		final String countryColumnName = "country_txt";
		if(checkForColumnValue(record, countryColumnName))
		{
			final String country = record.get(countryColumnName);
			locationPropertiesClient.setCountry(locationId, country);
		}
		
		// Set Region if exists
		final String regionColumnName = "region_txt";
		if(checkForColumnValue(record, countryColumnName))
		{
			final String region = record.get(regionColumnName);
			locationPropertiesClient.setRegion(locationId, region);
		}
		
		return locationId;
	}
	private static Long loadWeaponProperties(CSVRecord record, TProtocol protocol) throws TException
	{
		final String weaponProtocolStringID = "weaponProperties";
		TMultiplexedProtocol multiplexedProtocol = new TMultiplexedProtocol(protocol, weaponProtocolStringID);
		WeaponProperties.Client weaponPropertiesClient = new WeaponProperties.Client(multiplexedProtocol);
		
		// Get WeaponId
		final Long weaponId = Long.parseLong(record.get("weaptype1"));
		
		// Set Weapon description if exists
		final String descriptionColumnName = "weaptype1_txt";
		if(checkForColumnValue(record, descriptionColumnName))
		{
			final String description = record.get(descriptionColumnName);
			weaponPropertiesClient.setDescription(weaponId, description);
		}
		  
		return weaponId;
	}
	private static void loadAttackLocationRelationship(TProtocol protocol, Long attackId, Long locationId) throws TException
	{
		final String relationshipStringID = "attackLocationRelationship";
		TMultiplexedProtocol multiplexedProtocol = new TMultiplexedProtocol(protocol, relationshipStringID);
		AttackLocationRelationship.Client attackLocationRelationshipClient = new AttackLocationRelationship.Client(multiplexedProtocol);
		
		attackLocationRelationshipClient.setRelationship(attackId, locationId);
	}
	private static void loadAttackWeaponRelationship(TProtocol protocol, Long attackId, Long weaponId) throws TException
	{
		final String relationshipStringID = "attackWeaponRelationship";
		TMultiplexedProtocol multiplexedProtocol = new TMultiplexedProtocol(protocol, relationshipStringID);
		AttackWeaponRelationship.Client attackWeaponRelationshipClient = new AttackWeaponRelationship.Client(multiplexedProtocol);
		
		attackWeaponRelationshipClient.setRelationship(attackId, weaponId);
	}
	private static boolean checkForColumnValue(CSVRecord record, String columnName)
	{
		return record.isSet(columnName) && !record.get(columnName).isEmpty();
	}
}
