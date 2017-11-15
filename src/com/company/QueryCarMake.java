package com.company;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

public class QueryCarMake {

    public void searchForCarMake()
    {
        ConnectionToMongo connectionToMongo = new ConnectionToMongo();
        MongoCollection <BasicDBObject> collection = connectionToMongo.connection();

/s
        List<PersonalDetails> carMakeList = new ArrayList<>();

        //Specific Query
        BasicDBObject query = new BasicDBObject();
        query.put("CarMake", "BMW");

        MongoCursor <BasicDBObject> cursor = collection.find(query).iterator();

        while (cursor.hasNext()) {

            BasicDBObject carInsuranceObject = cursor.next();

            //converting Mongo Object (BSON) to java object
            ConvertingBsonToJava convert = new ConvertingBsonToJava();
            PersonalDetails personalDetails = convert.convertingObject(carInsuranceObject);

            carMakeList.add(personalDetails);
            System.out.println(personalDetails);
        }

        System.out.println("");
        System.out.println("There are " + carMakeList.size() + " matching profiles out of " + collection.count());
    }
}


//connections
//DB db = mongo.getDB("Car_Insurance_Details"); //name of database
//DBCollection collection = db.getCollection("Personal_Details"); //name of table
//MongoCollection<Document> collection = db.getCollection("Personal_Details");

//DBCursor cursor = collection.find(query);
//MongoCursor <Document> cursor = collection.find(query).iterator();