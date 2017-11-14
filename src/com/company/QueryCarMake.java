package com.company;

import com.mongodb.*;

import java.util.ArrayList;
import java.util.List;

public class QueryCarMake {

    public void searchForCarMake()
    {
        ConvertingBsonToJava convert = new ConvertingBsonToJava();

        MongoClient mongo = new MongoClient("localhost", 27017); //creating connection to MongoDB

        //get the connections
        DB db = mongo.getDB("Car_Insurance_Details"); //name of database
        DBCollection collection = db.getCollection("Personal_Details"); //name of table

        //Create List to hold objects
        List<PersonalDetails> carMakeList = new ArrayList<>();

        //Specific Query
        BasicDBObject query = new BasicDBObject();
        query.put("CarMake", "BMW");

        DBCursor cursor = collection.find(query);

        while (cursor.hasNext()) {
            BasicDBObject carInsuranceObject = (BasicDBObject) cursor.next();

            //converting Mongo Object (BSON) to java object
            PersonalDetails personalDetails = convert.convertingObject(carInsuranceObject);

            carMakeList.add(personalDetails);
            System.out.println(personalDetails);
        }

        System.out.println("");
        System.out.println("There are " + carMakeList.size() + " matching profiles out of " + collection.count());
    }
}
