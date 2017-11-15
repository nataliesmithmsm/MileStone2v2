package com.company;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ConnectionToMongo {

    public static MongoCollection<BasicDBObject> connection() //  DBCollection
    {
        //Connection to Mongodb
        MongoClient mongo = new MongoClient("localhost", 27017);

        //Database Connection
        MongoDatabase db = mongo.getDatabase("Car_Insurance_Details");

        //Collection Connection
        MongoCollection<BasicDBObject> collection = db.getCollection("Personal_Details", BasicDBObject.class);

       return collection;

    }
}
