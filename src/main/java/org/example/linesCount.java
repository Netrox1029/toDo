package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class linesCount {
    public static int getLines() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("JavaToDo.txt"));
        int lines = 1;
        while (reader.readLine() != null) lines++;
        return lines;
    }
}
