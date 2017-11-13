package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader
{
    //Reading CSV file into Array List
    public static List<PersonalDetails> readToArray(String commaSplitter, BufferedReader bufferedReader) throws IOException {

        FileReader fileReader = new FileReader();
        FileWriter fileWriter = new FileWriter();

        List<PersonalDetails> personList = new ArrayList<>();  //Array List to hold data
        String line = " ";

        bufferedReader.readLine(); //To skip first line of csv file

        while ((line = bufferedReader.readLine()) != null) {

            String[] personInfo = line.split(commaSplitter);

            PersonalDetails returnedPersonBuilder = fileReader.personBuilder(personInfo); //creating person object to add to personList

            personList.add(returnedPersonBuilder); //adding to person List
        }
        return personList;
    }

    //Creating person Object
    public PersonalDetails personBuilder(String [] personInfo)
    {
        PersonalDetails person = null;

        if (personInfo.length == 11) {

            Address address = new Address(Integer.parseInt(personInfo[2]), personInfo[3], personInfo[4], personInfo[5], personInfo[6]);
            CarDetails carDetails = new CarDetails(personInfo[7], personInfo[8], personInfo[9], Double.parseDouble(personInfo[10]));
            person = new PersonalDetails(personInfo[0], personInfo[1], address, carDetails);
            //personList.add(person);

        } else {
            System.out.println("Missing Data");
        }
        return person; //returning a personDetails object
    }
}

