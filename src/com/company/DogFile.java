package com.company;
import java.util.Scanner;
import java.io.*;

import static java.lang.Character.isDigit;

public class DogFile {

    public static Dog[] getAllDogs() throws IOException {

        Dog[] myDogs = new Dog[500];

        Scanner inFile = new Scanner(new File("dogs.txt"));

        int subCount = 0;
        while (inFile.hasNext()) {

            String line = inFile.nextLine();
            String[] temp = line.split("#");

            int dogID = Integer.parseInt(temp[0]);
            //String name;
            //String breed;
            //String sex;
            int age = Integer.parseInt(temp[4]);
            int weight = Integer.parseInt(temp[5]);

            myDogs[Dog.getCount()] = new Dog(dogID, temp[1], temp[2], temp[3], age, weight);

            Dog.setCount(Dog.getCount() + 1);

        } // end of while

        inFile.close();

        return myDogs;
    }

} // end of DogFile class
