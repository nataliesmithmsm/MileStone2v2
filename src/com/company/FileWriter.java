package com.company;
import com.mongodb.*;

import java.util.List;

public class FileWriter {

    public void insertDocument(List<PersonalDetails> profileList){  //ArrayList profileList, PersonalDetails person1

        MongoClient mongo = new MongoClient("localhost", 27017); //creating a Mongo Client

        //get the connections
        DB db = mongo.getDB("Car_Insurance_Details"); //name of database
        DBCollection collection = db.getCollection("Personal_Details"); //name of collection

        for (PersonalDetails profile : profileList)  {

            DBObject profileDBObject = new BasicDBObject();
            profileDBObject.put("FirstName", profile.getFirstName());
            profileDBObject.put("Surname", profile.getSurname());

            profileDBObject.put("HouseNumber", profile.getAddress().getHouseNumber());
            profileDBObject.put("Street", profile.getAddress().getStreet());
            profileDBObject.put("Town", profile.getAddress().getTown());
            profileDBObject.put("City", profile.getAddress().getCity());
            profileDBObject.put("PostCode", profile.getAddress().getPostcode());

            profileDBObject.put("CarRegistration", profile.getCarDetails().getCarRegistration());
            profileDBObject.put("CarMake", profile.getCarDetails().getCarMake());
            profileDBObject.put("CarModel", profile.getCarDetails().getCarModel());
            profileDBObject.put("EngineSize", profile.getCarDetails().getEngineSize());

            collection.insert(profileDBObject); //inserting object into mongo table
        }

    }

}



