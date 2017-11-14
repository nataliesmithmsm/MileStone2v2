package com.company;
import com.mongodb.*;

import java.util.ArrayList;
import java.util.List;

public class QueryStoreAddressSeparate {

   public void readInCollection()
    {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("Car_Insurance_Details");

        DBCollection collection = db.getCollection("Personal_Details");  //reading data from this collection

        List<Address> addressList = new ArrayList<>(); //new list to store Address

        //Query
        DBCursor cursor = collection.find();

        while (cursor.hasNext())
        {
            BasicDBObject carInsuranceObject = (BasicDBObject) cursor.next();

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

            addressList.add(address);
            System.out.println(address);
        }

        StoreToSeparateCollection(addressList, db);

    }

    public void StoreToSeparateCollection(List <Address> addressList, DB db)
    {
        DBCollection AddCollection = db.getCollection("Addresses"); //writing data to new collection

        for (Address address : addressList)  {

            DBObject AddressDBObject = new BasicDBObject();

            AddressDBObject.put("HouseNumber", address.getHouseNumber());
            AddressDBObject.put("Street", address.getStreet());
            AddressDBObject.put("Town", address.getTown());
            AddressDBObject.put("City", address.getCity());
            AddressDBObject.put("PostCode", address.getPostcode());

            AddCollection.insert(AddressDBObject);
        }

    }


}
