package com.company.query;
import com.company.Mongo.ConnectionToMongo;
import com.company.dataobjects.Address;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

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

            String houseNumber = carInsuranceObject.getString("HouseNumber");  //Reading only address Feilds from database
            String street = carInsuranceObject.getString("Street");
            String town = carInsuranceObject.getString("Town");
            String city = carInsuranceObject.getString("City");
            String postcode = carInsuranceObject.getString("PostCode");

            Address address = new Address();

            address.setHouseNumber(Integer.parseInt(houseNumber));  //storing address as java object
            address.setStreet(street);
            address.setTown(town);
            address.setCity(city);
            address.setPostcode(postcode);

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
            AddressDBObject.put("PostCode", address.getPostcode());

            addressCollection.insertOne(AddressDBObject);
        }
    }
}
