package com.company.query;

import com.company.Mongo.ConnectionToMongo;
import com.company.Mongo.ConvertingBsonToJava;
import com.company.dataobjects.PersonalDetails;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import java.util.ArrayList;
import java.util.List;

public class QueryDisplayLast10 {

    public void displayLast10Profiles(){

        //Connection to Mongodb
        MongoCollection<BasicDBObject> collection = ConnectionToMongo.connection();  //returns collection

        List<PersonalDetails> display10List = new ArrayList<>(); //new list to store items

        //Query
        MongoCursor<BasicDBObject> cursor = collection.find().sort(new BasicDBObject("$natural", -1)).limit(10).iterator();    //sorts list in descending order and reads first 10 items

        //Find matching profiles
        while (cursor.hasNext())
        {
            BasicDBObject carInsuranceObject = cursor.next();

            PersonalDetails personalDetails = ConvertingBsonToJava.convertingObject(carInsuranceObject); //convert from BSON to Java

            display10List.add(personalDetails);
            System.out.println(personalDetails);
        }

        System.out.println("");
        System.out.println("There are " + display10List.size() + " matching profiles out of " + collection.count());
        System.out.println("");
    }
}
