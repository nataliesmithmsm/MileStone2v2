package com.company.runners;

import com.company.filehelpers.FileHelper;

public class WritterRunner {

    public static void main(String[] args)
    {
        FileHelper fileHelper = new FileHelper();
        fileHelper.readingInCsvFile("ReadMe copy.csv");
    }
}
