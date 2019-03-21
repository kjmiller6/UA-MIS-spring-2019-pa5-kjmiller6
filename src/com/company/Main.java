package com.company;

import java.lang.*;
import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner keyboard = new Scanner(System.in);

        displayOptions(1); // display menu1
        //String input = keyboard.next();

        int codeType = 0;
        int inputA = getUserChoice();

        if (inputA == 0) { // fixme later lol
            inputA += 5;
        }

        while (inputA != 0) {

            if (inputA == 1) {

                separator(inputA);

            }
            if (inputA == 2) {

                separator(inputA);

            }
            displayOptions(1); // display menu1
            inputA = getUserChoice();

        } // end of while

    } // end of main

    public static void displayOptions(int displayType) {

        System.out.println("Please select an option to continue");

        if (displayType == 1) { // menu1
            System.out.println("#1 to encode or decode a file");
            System.out.println("#2 to find wordCount");
            System.out.println("#3 to quit.");
        }

        if (displayType == 2) { // menu2
            System.out.println("#1 to select an output file.");
            System.out.println("#2 to create an output file named output.txt ");
            System.out.println("#3 to quit and return to main menu");
        }

        if (displayType == 3) { // menu3
            System.out.println("#1 to select an input file.");
            System.out.println("#2 to use a File named input.txt");
            System.out.println("#3 to quit and return to main menu");
        }

    } // end of displayOptions

    public static int getUserChoice() { // general menu used for input for most methods

        int inputType = 0;

        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.next();

        switch (input) {

            case "1":
                inputType = 1;
                break;

            case "2":
                inputType = 2;

                break;

            case "3":
                inputType = 0;
                break;

            default:
                System.out.print("Error selected, returning to main menu");
                inputType = 0;
                break;

        } // end of switch

        return inputType;
    } // end of getUserChoice

    public static void separator(int codeType) throws IOException {

        Scanner keyboard = new Scanner(System.in);
        String inFileName = "input.txt"; // default initializer, unchanged unless user selects option 1 from getMenuChoice menu3

        displayOptions(3); // display menu3
        int fileType = getUserChoice();

        if (fileType == 0) { // if user chose to quit
            return;
        } else if (fileType == 1) { // if user chose to input file
            System.out.println("Please enter the name of the file you want to output to. make sure to include the .txt");
            inFileName = keyboard.next();
        }

        try { // error try incase file selected does not exist
            String source = new Scanner(new File(inFileName)).useDelimiter("\\Z").next(); // scans file as single string


            char arr[] = source.toCharArray(); // separates file into characters
            int wordCount = 1; // initial word count of 1

            for (int i = 0; i < arr.length; i++) {

                if (arr[i] == ' ') { // if there is a space, wordCount increases by 1
                    wordCount++;
                }

            } // end of for

            System.out.println("Your file has " + wordCount + " words.");

            if (codeType == 1) { // if user selects code/decode file
                coder(arr);
            }

        } // end of try
        catch (IOException ex) { // catches IO exception returns to main menu if true
            System.out.println(ex.toString());
            System.out.println("Could not find file " + inFileName);
        } // end of catch

    } // end of separator

    public static void coder(char[] arr) throws IOException {

        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'}; // normal alphabet
        char[] rot13 = {'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm'}; // rot13 cipher

        for (int i = 0; i < arr.length; i++) { // (A) for all characters in the file

            for (int j = 0; j < 26; j++) { // (B) // for all letters in the alphabet

                if (arr[i] == alphabet[j]) {// sets array elements if alphabet matches rot13

                    arr[i] = rot13[j];

                    break;
                }

            } // end of for (B)

        } // end of for (A)

        System.out.println(arr); // tester

        writeToFile(arr);
    } // end of coder

    public static void writeToFile(char[] arr) throws IOException {

        displayOptions(2); // display menu2
        int fileType = getUserChoice();

        Scanner keyboard = new Scanner(System.in);

        String outFileName = "output.txt"; // default file initializer, remains unchanged if user selects option 2 from menu2

        if (fileType == 0) { // if user chose to quit
            return;
        }

        if (fileType == 1) { // if user chose to input file name
            System.out.println("Please enter the name of the file you want to output to. make sure to include the .txt");
            outFileName = keyboard.next();
        }

        PrintWriter outFile = new PrintWriter(outFileName);
        outFile.print(arr); // prints array to outfile selected

        outFile.close(); // closes file

    } // end of writeToFile

} // end of class main
