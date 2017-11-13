package com.company;

import com.mongodb.*;

import java.util.ArrayList;
import java.util.List;

public class QueryPostCodes {

    public void searchForPostcodes()
    {
        //referance to class
        ConvertingBsonToJava convert = new ConvertingBsonToJava();

        //Create Connection
        MongoClient mongo = new MongoClient("localhost", 27017); //creating a Mongo Client

        //get the connections
        DB db = mongo.getDB("Car_Insurance_Details"); //name of database
        DBCollection collection = db.getCollection("Personal_Details"); //name of table

        //Create List to hold objects
        List<PersonalDetails> carInsuranceList = new ArrayList<>();

        //Specific Query
        BasicDBObject query = new BasicDBObject();
        query.put("PostCode", "SK11 NUS");

        DBCursor cursor = collection.find(query);

        while (cursor.hasNext()) {

            BasicDBObject Profile = (BasicDBObject) cursor.next();

            //converting Mongo Object (BSON) to java object
            PersonalDetails personalDetails = convert.convertingObject(Profile);

            carInsuranceList.add(personalDetails);
            System.out.println(personalDetails);
        }

        System.out.println(collection.count());

    }
}
