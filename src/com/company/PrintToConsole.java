package com.company;

import com.mongodb.*;
import com.sun.security.ntlm.Client;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class PrintToConsole {

    public void printMongoDB() {

        ConvertingBsonToJava convert = new ConvertingBsonToJava();

        MongoClient mongo = new MongoClient("localhost", 27017); //creating a Mongo Client

        //get the connections
        DB db = mongo.getDB("Car_Insurance_Details"); //name of database
        DBCollection collection = db.getCollection("Personal_Details"); //name of table

        List <PersonalDetails> carInsuranceList = new ArrayList<>();

        DBCursor cursor = collection.find();

        while (cursor.hasNext()) {

            BasicDBObject carInsuranceObject = (BasicDBObject) cursor.next();

            //converting Mongo Object (BSON) to java object
            PersonalDetails personalDetails = convert.convertingObject(carInsuranceObject);

            String firstname = carInsuranceObject.getString("FirstName");
            String surname = carInsuranceObject.getString("Surname");
            String houseNumber = carInsuranceObject.getString("HouseNumber");  //int houseNumber = carInsuranceObject.getInt("HouseNumber"); //
            String street = carInsuranceObject.getString("Street");
            String town = carInsuranceObject.getString("Town");
            String city = carInsuranceObject.getString("City");
            String postcode = carInsuranceObject.getString("PostCode");
            String carRegistration = carInsuranceObject.getString("CarRegistration");
            String carMake = carInsuranceObject.getString("CarMake");
            String carModel = carInsuranceObject.getString("CarModel");
            double engineSize = carInsuranceObject.getDouble("EngineSize");

            PersonalDetails person = new PersonalDetails();
            person.setFirstName(firstname);
            person.setSurname(surname);

            Address address = new Address();
            address.setHouseNumber(Integer.parseInt(houseNumber));  //address.setHouseNumber(houseNumber);
            address.setStreet(street);
            address.setTown(town);
            address.setCity(city);
            address.setPostcode(postcode);
            person.setAddress(address);

            CarDetails carDetails = new CarDetails();
            carDetails.setCarRegistration(carRegistration);
            carDetails.setCarModel(carModel);
            carDetails.setCarMake(carMake);
            carDetails.setEngineSize(engineSize);
            person.setCarDetails(carDetails);

//            carInsuranceList.add(person);
//            System.out.println(person);
            carInsuranceList.add(personalDetails);
            System.out.println(personalDetails);
        }

//        List<DBObject> carInsurance = collection.find().toArray();
//
//        for (DBObject person : carInsurance)
//        {
//            System.out.println(carInsurance.toString());
//        }

        //System.out.println(carInsuranceList);

        System.out.println(collection.count());
    }
}
