package com.company.query;

import com.company.Mongo.ConnectionToMongo;
import com.company.Mongo.ConvertingBsonToJava;
import com.company.dataobjects.PersonalDetails;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class QueryPostCodes {

    public void searchForPostcodes()
    {
        //Connection to Mongodb, database and Collection
        MongoCollection<BasicDBObject> collection = ConnectionToMongo.connection();  //returns collection

        //Create List to hold objects
        List<PersonalDetails> postcodeList = new ArrayList<>();

        //QueryObject
        BasicDBObject query = new BasicDBObject();

        //Query
        String pattern1 = ".*" + "SK11" + ".*";
        Pattern stringPattern = Pattern.compile(pattern1);
        query.put("PostCode", stringPattern);

        MongoCursor<BasicDBObject> cursor = collection.find(query).iterator();

        while (cursor.hasNext()) {
            BasicDBObject Profile = cursor.next();

            //converting Mongo Object (BSON) to java object
            PersonalDetails personalDetails = ConvertingBsonToJava.convertingObject(Profile);

            postcodeList.add(personalDetails);
            System.out.println(personalDetails);
        }

        System.out.println("");
        System.out.println("There are " + postcodeList.size() + " matching profiles out of " + collection.count());
        System.out.println("");
    }
}
