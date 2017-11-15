package com.company;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class ConnectionToMongo {

    public MongoCollection<BasicDBObject> connection() //  DBCollection
    {
        MongoClient mongo = new MongoClient("localhost", 27017); //creating connection to MongoDB

        //Database Connection
        MongoDatabase db = mongo.getDatabase("Car_Insurance_Details");
        //Collection Connection
        MongoCollection<BasicDBObject> collection = db.getCollection("Personal_Details", BasicDBObject.class);

      return collection;

        //        MongoClient mongoClient = new MongoClient("localhost", 27017);
//
//
//        DB db = mongoClient.getDB("Car_Insurance_Details");
//
//
//        DBCollection collection = db.getCollection("Personal_Details");  //reading data from this collection
//
//        return collection;
    }
}
