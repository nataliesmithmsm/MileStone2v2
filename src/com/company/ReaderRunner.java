package com.company;

public class ReaderRunner {

    public static void main(String[] args)
    {
        //Print out all documents
//        PrintToConsole printToConsole = new PrintToConsole();
//        printToConsole.printMongoDB();  //Printing

        //Print out documents that drive BMW
//        QueryCarMake queryCarMake = new QueryCarMake();
//        queryCarMake.searchForCarMake();


        //Print out documents that have postcodes begining with SK11
        QueryPostCodes queryPostCodes = new QueryPostCodes();
        queryPostCodes.searchForPostcodes();
    }
}


//DBQuery.shellBatchSize = 10  