package com.company.dataobjects;

import org.codehaus.jackson.annotate.JsonProperty;

public class Address {

    private int HouseNumber;
    private String Street;
    private String Town;
    private String City;
    private String Postcode;

    public Address() { }

    public Address(int HouseNumber, String Street, String Town, String City, String Postcode)
    {
        setHouseNumber(HouseNumber);
        setStreet(Street);
        setTown(Town);
        setCity(City);
        setPostcode(Postcode);
    }

    public int getHouseNumber() {
        return HouseNumber;
    }

    public void setHouseNumber(int houseNumber) { this.HouseNumber = houseNumber;  }

    public String getStreet() { return Street; }

    public void setStreet(String street) { this.Street = street; }

    public String getTown() { return Town; }

    public void setTown(String town) { this.Town = town; }

    public String getCity() { return City;  }

    public void setCity(String city) { this.City = city; }

    public String getPostcode() { return Postcode;  }

    public void setPostcode(String postcode) { this.Postcode = postcode;  }


    @Override
    public  String toString()
    {
        return getHouseNumber() + " " + getStreet() + " " + getTown() + " " + getCity() + " " + getPostcode();

    }
}

