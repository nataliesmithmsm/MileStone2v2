package com.company;

import com.mongodb.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class QueryPostCodes {

    public void searchForPostcodes()
    {
        ConvertingBsonToJava convert = new ConvertingBsonToJava(); //referance to class

        //Create Connection
        MongoClient mongo = new MongoClient("localhost", 27017); //creating a Mongo Client

        //get the connections
        DB db = mongo.getDB("Car_Insurance_Details"); //name of database
        DBCollection collection = db.getCollection("Personal_Details"); //name of table

        //Create List to hold objects
        List<PersonalDetails> postcodeList = new ArrayList<>();

        //QueryObject
        BasicDBObject query = new BasicDBObject();

         //Query
        String pattern1 = ".*" + "SK11" + ".*";
        Pattern stringPattern = Pattern.compile(pattern1);
        query.put("PostCode", stringPattern);

        DBCursor cursor = collection.find(query);

        while (cursor.hasNext()) {
            BasicDBObject Profile = (BasicDBObject) cursor.next();

            //converting Mongo Object (BSON) to java object
            PersonalDetails personalDetails = convert.convertingObject(Profile);

            postcodeList.add(personalDetails);
            System.out.println(personalDetails);
        }

        System.out.println("");
        System.out.println("There are " + postcodeList.size() + " matching profiles out of " + collection.count());
    }
}
