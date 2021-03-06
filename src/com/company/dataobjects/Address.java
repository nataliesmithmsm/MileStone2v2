package com.company.dataobjects;

import org.codehaus.jackson.annotate.JsonProperty;

public class Address {

    @JsonProperty("HouseNumber")
    private int HouseNumber;

    @JsonProperty("Street")
    private String Street;

    @JsonProperty("Town")
    private String Town;

    @JsonProperty("City")
    private String City;

    @JsonProperty("PostCode")
    private String PostCode;

    public Address() { }

    public Address(int HouseNumber, String Street, String Town, String City, String Postcode)
    {
        setHouseNumber(HouseNumber);
        setStreet(Street);
        setTown(Town);
        setCity(City);
        setPostCode(Postcode);
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

    public String getPostCode() { return PostCode;  }

    public void setPostCode(String postcode) { this.PostCode = postcode;  }


    @Override
    public  String toString()
    {
        return getHouseNumber() + " " + getStreet() + " " + getTown() + " " + getCity() + " " + getPostCode();

    }
}

