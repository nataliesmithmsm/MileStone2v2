package com.company;
import com.mongodb.*;

import java.util.List;

public class FileWriter {

    public void insertDocument(List<PersonalDetails> personList){  //ArrayList personList, PersonalDetails person1

        MongoClient mongo = new MongoClient("localhost", 27017); //creating a Mongo Client

        //get the connections
        DB db = mongo.getDB("Car_Insurance_Details"); //name of database
        DBCollection table = db.getCollection("Personal_Details"); //name of table

        //Inserting a document
        BasicDBObject documentDetail = new BasicDBObject();

        for (PersonalDetails person : personList)  {

            DBObject personDBObject = new BasicDBObject();
            personDBObject.put("FirstName", person.getFirstName());
            personDBObject.put("Surname", person.getSurname());
            personDBObject.put("HouseNumber", person.getAddress().getHouseNumber());
            personDBObject.put("Street", person.getAddress().getStreet());
            personDBObject.put("Town", person.getAddress().getTown());
            personDBObject.put("City", person.getAddress().getCity());
            personDBObject.put("PostCode", person.getAddress().getPostcode());
            personDBObject.put("CarRegistration", person.getCarDetails().getCarRegistration());
            personDBObject.put("CarMake", person.getCarDetails().getCarMake());
            personDBObject.put("CarModel", person.getCarDetails().getCarModel());
            personDBObject.put("EngineSize", person.getCarDetails().getEngineSize());

            table.insert(personDBObject);
//            System.out.println(personDBObject);
        }

    }

}



