package com.company.dataobjects;

public class PersonalDetails {

    private String firstName;
    private String surname;
    private Address address;
    private CarDetails carDetails;

    public PersonalDetails ()
    { }

    public PersonalDetails (String FirstName, String Surname, Address address, CarDetails carDetails)
    {
        setFirstName(FirstName);
        setSurname(Surname);
        setAddress(address);
        setCarDetails(carDetails);
    }

    public String getFirstName() { return firstName;  }

    public void setFirstName(String firstName) { this.firstName = firstName;  }

    public String getSurname() { return surname; }

    public void setSurname(String surname) {  this.surname = surname;  }

    public Address getAddress() {  return address;  }

    public void setAddress(Address address) {  this.address = address; }

    public CarDetails getCarDetails() {  return carDetails; }

    public void setCarDetails(CarDetails carDetails) {  this.carDetails = carDetails; }


    @Override
    public String toString()
    {
        return getFirstName() + " " + getSurname() + " " + address.toString() +  " " + carDetails.toString();
    }



}
