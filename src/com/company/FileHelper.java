package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {

    private static final String commaSplitter = ",";
    FileWriter fileWriter = new FileWriter();
    com.company.FileReader fileReader = new com.company.FileReader();

    public void readingInCsvFile()
    {
        BufferedReader bufferedReader = null;


        String csvFile = "ReadMe copy.csv";

        try {
           bufferedReader = new BufferedReader(new FileReader(csvFile)); //opens file ready to read

           List<PersonalDetails> personList = fileReader.readToArray(commaSplitter, bufferedReader); //Reading in Csv file into an array, returns a person list

           fileWriter.insertDocument(personList);  //writing File to MongoDB ONLY RUN ONCE
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        finally{
            try {
                bufferedReader.close();
            }
            catch (IOException ee) {
                ee.printStackTrace();
            }
        }
    }

}
