package com.company.filehelpers;
import com.company.Mongo.ConnectionToMongo;
import com.company.dataobjects.PersonalDetails;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;

import java.util.List;

public class MongoWriter {

    public void insertDocumentToMongo(List<PersonalDetails> profileList)  {  //ArrayList profileList, PersonalDetails person1

        //Connection to Mongodb, database and Collection
        MongoCollection<BasicDBObject> collection = ConnectionToMongo.connection();  //returns collection

        for (PersonalDetails profile : profileList)  {

            BasicDBObject profileDBObject = new BasicDBObject();
            profileDBObject.put("FirstName", profile.getFirstName());
            profileDBObject.put("Surname", profile.getSurname());

            BasicDBObject address = new BasicDBObject();
            address.put("HouseNumber", profile.getAddress().getHouseNumber());
            address.put("Street",profile.getAddress().getStreet());
            address.put("Town", profile.getAddress().getTown());
            address.put("City", profile.getAddress().getCity());
            address.put("PostCode", profile.getAddress().getPostcode());

            BasicDBObject carDetails = new BasicDBObject();
            carDetails.put("CarRegistration", profile.getCarDetails().getCarRegistration());
            carDetails.put("CarMake", profile.getCarDetails().getCarMake());
            carDetails.put("CarModel",profile.getCarDetails().getCarModel());
            carDetails.put("EngineSize", profile.getCarDetails().getEngineSize());

            profileDBObject.put("Address", address);
            profileDBObject.put("Car Details", carDetails);

            //inserting object into Mongodb table
            collection.insertOne(profileDBObject);
        }

    }

}



