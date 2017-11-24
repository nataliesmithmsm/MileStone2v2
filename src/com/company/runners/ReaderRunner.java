package com.company.runners;

import com.company.dataobjects.PersonalDetails;
import com.company.query.QueryCarMake;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReaderRunner {

    public static void main(String[] args) throws IOException {
       /* //Print out all documents
        System.out.println("------ All Profiles ------");
        QueryPrintAll queryPrintAll = new QueryPrintAll();
        queryPrintAll.printAllDocuments();  //Printing*/

        //Print out documents that drive BMW
        System.out.println("------ Profiles that have BMW car makes ------");
        QueryCarMake queryCarMake = new QueryCarMake();
        List<PersonalDetails> personsWithBMW = queryCarMake.searchForCarsWithBMW();
        assertEquals(personsWithBMW.size(), 6);
        System.out.println(personsWithBMW.size()); //take out

     //   assertNotNull(personsWithBMW.get(0).getAddress());

/*
        //Print out documents that have postcodes beginning with SK11
        System.out.println("------ Profiles that have postcode beginning with SK11 ------");
        QueryPostCodes queryPostCodes = new QueryPostCodes();
        queryPostCodes.searchForPostcodes();

        //Print out last 10 entries in the List
        System.out.println("------ Last 10 Profiles in the Collection ------");
        QueryDisplayLast10 queryDisplayLast10 = new QueryDisplayLast10();
        queryDisplayLast10.displayLast10Profiles();

        //Storing Address in separate Collection
        System.out.println("------ Storing Address to a separate collection ------");
        QueryStoreAddressSeparate queryStoreAddressSeparate = new QueryStoreAddressSeparate();
        queryStoreAddressSeparate.readInCollection();*/
    }
}

