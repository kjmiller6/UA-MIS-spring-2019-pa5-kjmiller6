package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    // alright ill keep it short, messed around way too much on the project.
    // wasn't going to submit but was convinced otherwise.
    // program has no options, will read a file if that file provides dog ID's
    // gives a report sorted by ID
    // and writes that list to a file named "masterFile.txt
    //

    public static void main(String[] args) throws IOException {

        Dog[] myDogs = DogFile.getAllDogs();
        Dog.sortDogs(myDogs);
        WriteToFile.writeDogInfo(myDogs);
        Report.Report(myDogs);

    } // end of void main

} // end of class main
