package com.company;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class ConnectionToMongo {

    public DBCollection connection()
    {
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        //Database Connection
        DB db = mongoClient.getDB("Car_Insurance_Details");

        //Collection Connection
        DBCollection collection = db.getCollection("Personal_Details");  //reading data from this collection

        return collection;
    }
}
