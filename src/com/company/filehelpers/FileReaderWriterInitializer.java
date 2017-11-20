package com.company.filehelpers;

import com.company.dataobjects.PersonalDetails;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileReaderWriterInitializer {

    MongoWriter mongoWriter = new MongoWriter();

    public void readCsvFileAndWriteMongo(String csvFile)
    {
        BufferedReader bufferedReader = null;

        try {
           bufferedReader = new BufferedReader(new FileReader(csvFile)); //opens file ready to read

           List<PersonalDetails> ProfileList = CsvReadToList.readCsvToArray(bufferedReader); //Reading in Csv file into an array, returns a person list

            mongoWriter.insertDocumentToMongo(ProfileList);  //writing File to MongoDB, ONLY RUN ONCE

            System.out.println("Documents have been successfully written to Mongodb collection!");
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
