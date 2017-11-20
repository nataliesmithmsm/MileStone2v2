package com.company.filehelpers;

import com.company.dataobjects.Address;
import com.company.dataobjects.CarDetails;
import com.company.dataobjects.PersonalDetails;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CsvReadToList {

    //Reading CSV file into Array List
    public static List<PersonalDetails> readCsvToArray(Reader bufferedReader) throws IOException {

        String commaSplitter = ",";
        List<PersonalDetails> profileList = new ArrayList<>();  //Array List to hold data
        String line = " ";

        BufferedReader reader = new BufferedReader(bufferedReader);
        reader.readLine(); //To skip first line of csv file

        while ((line = reader.readLine()) != null) {

            String[] personInfo = line.split(commaSplitter);

            PersonalDetails returnedProfileBuilder = StringArrayToProfileObject(personInfo); //creating person object to add to profileList

            //Add each object to ProfileList
            profileList.add(returnedProfileBuilder); //adding to person List
        }
        return profileList;
    }

    //Creating person Object
    public static PersonalDetails StringArrayToProfileObject(String[] personInfo) {
        PersonalDetails profile = null;

        if (personInfo.length == 11) {

            Address address = new Address(Integer.parseInt(personInfo[2]), personInfo[3], personInfo[4], personInfo[5], personInfo[6]);
            CarDetails carDetails = new CarDetails(personInfo[7], personInfo[8], personInfo[9], Double.parseDouble(personInfo[10]));
            profile = new PersonalDetails(personInfo[0], personInfo[1], address, carDetails);

        } else {
            System.out.println("Missing Data");
        }
        return profile; //returning a personDetails object
    }
}

