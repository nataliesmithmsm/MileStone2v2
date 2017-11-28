package com.company.query;
import com.company.Mongo.ConnectionToMongo;
import com.company.dataobjects.Address;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.oracle.tools.packager.Log;
import org.bson.Document;
import sun.awt.SunHints;

import java.util.ArrayList;
import java.util.List;

public class QueryStoreAddressSeparate {

   public void readInCollection()
   {
        //Connection to Mongo - reading in Personal_Details collection
        MongoCollection<BasicDBObject> collection = ConnectionToMongo.connection();

        //list to store addresses
        List<Address> addressList = new ArrayList<>(); //new list to store Address

        //Query
        MongoCursor<BasicDBObject> cursor = collection.find().iterator();

        while (cursor.hasNext())
        {
            BasicDBObject carInsuranceObject = cursor.next();

            DBObject getAddresses = (BasicDBObject) carInsuranceObject.get("Address");

            Integer houseNumber = (Integer) getAddresses.get("HouseNumber");
            String street = (String) getAddresses.get("Street");
            String town = (String) getAddresses.get("Town");
            String city = (String) getAddresses.get("City");
            String postcode = (String) getAddresses.get("PostCode");

            Address address = new Address();

            address.setHouseNumber(houseNumber);  //storing address as java object
            address.setStreet(street);
            address.setTown(town);
            address.setCity(city);
            address.setPostCode(postcode);

            //Add each item to Address List
            addressList.add(address);
            System.out.println(address);
        }
        StoreToSeparateCollection(addressList);
    }

    public void StoreToSeparateCollection(List <Address> addressList)
    {
        //Creating new connection to Address collection
        MongoCollection<BasicDBObject> addressCollection = ConnectionToMongo.connectionToAddress();

        for (Address address : addressList)  {

           BasicDBObject AddressDBObject = new BasicDBObject();

            AddressDBObject.put("HouseNumber", address.getHouseNumber());
            AddressDBObject.put("Street", address.getStreet());
            AddressDBObject.put("Town", address.getTown());
            AddressDBObject.put("City", address.getCity());
            AddressDBObject.put("PostCode", address.getPostCode());

            addressCollection.insertOne(AddressDBObject);
        }
    }
}
