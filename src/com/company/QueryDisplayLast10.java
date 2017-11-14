package com.company;

import com.mongodb.*;

import java.util.ArrayList;
import java.util.List;

public class QueryDisplayLast10 {

    public void displayLast10Profiles(){

        //Connection to Mongodb
        ConnectionToMongo connectionToMongo = new ConnectionToMongo();
        DBCollection collection = connectionToMongo.connection();

        List<PersonalDetails> display10List = new ArrayList<>(); //new list to store items

        //Query
        DBCursor cursor = collection.find().sort(new BasicDBObject("$natural", -1)).limit(10); //finds all documents sorts in descending orders and displays first 10 items

        //Finding matching profiles
        while (cursor.hasNext())
        {
            BasicDBObject carInsuranceObject = (BasicDBObject) cursor.next();

            ConvertingBsonToJava convert = new ConvertingBsonToJava();

            PersonalDetails personalDetails = convert.convertingObject(carInsuranceObject); //convert from BSON to Java

            display10List.add(personalDetails);
            System.out.println(personalDetails);
        }

        System.out.println("");
        System.out.println("There are " + display10List.size() + " matching profiles out of " + collection.count());
    }
}
