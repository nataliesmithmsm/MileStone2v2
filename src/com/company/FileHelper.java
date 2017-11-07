package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHelper {

    private static final String commaSplitter = ",";

    public void readingInCsvFile()
    {
        BufferedReader bufferedReader = null;

        String csvFile = "ReadMe copy.csv";

        try
        {
           bufferedReader = new BufferedReader(new FileReader(csvFile)); //opens file ready to read

            //com.company.FileReader fileReader = new com.company.FileReader(commaSplitter, br);

            ArrayList<PersonalDetails> personList = new ArrayList<>();  //Array List to hold data
            String line = " ";

            bufferedReader.readLine(); //to skip first line of csv file


            while ((line = bufferedReader.readLine()) != null)
            {
                String [] personInfo = line.split(commaSplitter);
                PersonalDetails person = null;


                if (personInfo.length == 11)
                {
                    //creatingPersonObject(personInfo, person);
                    Address address = new Address(Integer.parseInt(personInfo[2]), personInfo[3], personInfo[4], personInfo[5], personInfo[6]);
                    CarDetails carDetails = new CarDetails(personInfo[7], personInfo[8], personInfo[9], Double.parseDouble(personInfo[10]));
                    person = new PersonalDetails(personInfo[0], personInfo[1], address, carDetails);
                    personList.add(person);
                }
                else
                {
                    System.out.println("Missing Data");
                }
            }

            for(int i = 0; i < personList.size(); i++)

            {
                PersonalDetails person1 = personList.get(i);
                System.out.println(person1.toString());
                //savingFileToDB method goes here (person, i)
            }

        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        finally {
            try
            {
                bufferedReader.close();
            }
            catch (IOException ee)
            {
                ee.printStackTrace();
            }
        }
    }


//    public PersonalDetails creatingPersonObject(String [] personInfo, PersonalDetails person)
//    {
//        Address address = new Address(Integer.parseInt(personInfo[2]), personInfo[3], personInfo[4], personInfo[5], personInfo[6]);
//        CarDetails carDetails = new CarDetails(personInfo[7], personInfo[8], personInfo[9], Double.parseDouble(personInfo[10]));
//        person = new PersonalDetails(personInfo[0], personInfo[1], address, carDetails);
//
//        return person;
//    }


}
