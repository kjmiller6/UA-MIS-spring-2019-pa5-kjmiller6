package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteToFile {

    public static void writeDogInfo(Dog[] myDogs) throws IOException {

        FileWriter fileWriter = new FileWriter("masterFile.txt", true);
        PrintWriter outFile = new PrintWriter(fileWriter);

        for (int i = 0; i < Dog.getCount(); ++i) {
            outFile.println(myDogs[i]);
        }

        outFile.close();
    }
}
