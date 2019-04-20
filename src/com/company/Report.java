package com.company;

public class Report {

    public static void Report(Dog[] myDogs)
    {
        System.out.println("report of dogs: ");

        for (int i=0; i<Dog.getCount(); i++) {

            System.out.println(myDogs[i].toString());

        } // end of for

    }


} // end of class report
