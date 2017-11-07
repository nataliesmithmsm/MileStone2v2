package com.company;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class FileWriter {

    public void insertToDocument(){

        MongoClient mongo = new MongoClient("localhost", 27017); //creating a Mongo Client

        //get the connections
        DB db = mongo.getDB("Car_Insurance_Details"); //name of database
        DBCollection table = db.getCollection("Personal Details"); //name of table


        //Inserting a document
        BasicDBObject documentDetail = new BasicDBObject();

        documentDetail.put("First_Name", "Natalie");
        documentDetail.put("Surname", "Smith");
        documentDetail.put("House_Number", 35);
        documentDetail.put("Street", "Donalds Way");
        documentDetail.put("Town ", "Aigburth");
        documentDetail.put("City", "Liverpool");
        documentDetail.put("Postcode", "L17 0EN");
        documentDetail.put("Car Registration", "MJ62 COH");
        documentDetail.put("Car Make", "VW");
        documentDetail.put("Car Model", "UP!");
        documentDetail.put("Engine Size", 2.0);

        table.insert(documentDetail);

    }

}



