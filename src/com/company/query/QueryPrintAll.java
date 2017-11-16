package com.company.query;

import com.company.Mongo.ConnectionToMongo;
import com.company.Mongo.ConvertingBsonToJava;
import com.company.dataobjects.PersonalDetails;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import java.util.ArrayList;
import java.util.List;

public class QueryPrintAll {

    public void printAllDocuments() {

        //connection to MongoDB Collection
        MongoCollection<BasicDBObject> collection = ConnectionToMongo.connection();

        //ArrayList to store documents
        List <PersonalDetails> profileList = new ArrayList<>();

        //Query Find all documents in Collection
        MongoCursor<BasicDBObject> cursor = collection.find().iterator();  //DBCursor cursor = collection.find();

        while (cursor.hasNext()) {

            BasicDBObject profileObject = cursor.next(); //Creating BasicDBObject

            //converting Mongo Object (BSON) to java object
            PersonalDetails personalDetails = ConvertingBsonToJava.convertingObject(profileObject);

            //adding java object to list
            profileList.add(personalDetails);
            System.out.println(personalDetails);
        }

        System.out.println("");
        System.out.println("Total amount in collection " + collection.count());
        System.out.println("");
    }
}
