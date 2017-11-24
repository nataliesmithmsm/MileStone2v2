package com.company.dataobjects;

import com.mongodb.ReflectionDBObject;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties
public class PersonalDetails extends ReflectionDBObject {

    @JsonProperty("FirstName")
    private String FirstName;

    @JsonProperty("Surname")
    private String Surname;

    @JsonProperty("Address")
    private Address Address;

    @JsonProperty("CarDetails")
    private CarDetails CarDetails;

    public PersonalDetails ()
    { }

    public PersonalDetails (String FirstName, String Surname, Address address, CarDetails carDetails)
    {
        setFirstName(FirstName);
        setSurname(Surname);
        setAddress(address);
        setCarDetails(carDetails);
    }

    public String getFirstName() { return FirstName;  }

    public void setFirstName(String firstName) { this.FirstName = firstName;  }

    public String getSurname() { return Surname; }

    public void setSurname(String surname) {  this.Surname = surname;  }

    public Address getAddress() {  return Address;  }

    public void setAddress(Address address) {  this.Address = address; }

    public CarDetails getCarDetails() {  return CarDetails; }

    public void setCarDetails(CarDetails carDetails) {  this.CarDetails = carDetails; }


    @Override
    public String toString()
    {
        return getFirstName() + " " + getSurname() + " " + Address.toString() +  " " + CarDetails.toString();
    }



}
