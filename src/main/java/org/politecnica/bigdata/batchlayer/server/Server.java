package org.politecnica.bigdata.batchlayer.server;

import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.politecnica.bigdata.batchlayer.server.handlers.AttackLocationRelationshipHandler;
import org.politecnica.bigdata.batchlayer.server.handlers.AttackPropertiesHandler;
import org.politecnica.bigdata.batchlayer.server.handlers.AttackWeaponRelationshipHandler;
import org.politecnica.bigdata.batchlayer.server.handlers.LocationPropertiesHandler;
import org.politecnica.bigdata.batchlayer.server.handlers.WeaponPropertiesHandler;

public class Server {
	public static void main(String[] args) {
		try {
			AttackPropertiesHandler attackPropertiesHandler = new AttackPropertiesHandler();
			LocationPropertiesHandler locationPropertiesHandler = new LocationPropertiesHandler();
			WeaponPropertiesHandler weaponPropertiesHandler = new WeaponPropertiesHandler();
			AttackLocationRelationshipHandler attackLocationRelationshipHandler = new AttackLocationRelationshipHandler();
			AttackWeaponRelationshipHandler attackWeaponRelationshipHandler = new AttackWeaponRelationshipHandler();

			TMultiplexedProcessor multiplexedProcessor = new TMultiplexedProcessor();

			AttackProperties.Processor attackPropertiesProcessor = new AttackProperties.Processor(
					attackPropertiesHandler);
			multiplexedProcessor.registerProcessor("attackProperties", attackPropertiesProcessor);

			LocationProperties.Processor locationPropertiesProcessor = new LocationProperties.Processor(
					locationPropertiesHandler);
			multiplexedProcessor.registerProcessor("locationProperties", locationPropertiesProcessor);

			WeaponProperties.Processor weaponPropertiesProcessor = new WeaponProperties.Processor(
					weaponPropertiesHandler);
			multiplexedProcessor.registerProcessor("weaponProperties", weaponPropertiesProcessor);

			AttackLocationRelationship.Processor attackLocationRelationshipProcessor = new AttackLocationRelationship.Processor(
					attackLocationRelationshipHandler);
			multiplexedProcessor.registerProcessor("attackLocationRelationship", attackLocationRelationshipProcessor);

			AttackWeaponRelationship.Processor attackWeaponRelationshipProcessor = new AttackWeaponRelationship.Processor(
					attackWeaponRelationshipHandler);
			multiplexedProcessor.registerProcessor("attackWeaponRelationship", attackWeaponRelationshipProcessor);

			final int port = 9090;
			TServerTransport serverTransport = new TServerSocket(port);
			TServer server = new TSimpleServer(new Args(serverTransport).processor(multiplexedProcessor));

			System.out.println("Starting server at port " + port);
			server.serve();
			System.out.println("Server stoped");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
