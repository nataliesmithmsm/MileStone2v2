package com.company;

import com.mongodb.BasicDBObject;

public class ConvertingBsonToJava {

    public PersonalDetails convertingObject(BasicDBObject carInsuranceObject, PersonalDetails personObject)
    {
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

        return person;

    }
}
