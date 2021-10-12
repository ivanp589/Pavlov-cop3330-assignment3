package ex45;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 ivan pavlov
 */

public class wordFinder {
    //open the file containing the original string to be modified
    //break the original string down to an array of string to make altering
    //a specific string easier
    //find all occurances of the particular word and replace it
    public static void main(String[] args) throws IOException {
        wordFinder wordFinder = new wordFinder();
        String originalString = wordFinder.getOriginalString();
        String newString = wordFinder.getNewString(originalString);
        System.out.println(newString);
    }
    //replace all occurances of a word with a different word
    //after the original string is broken down to an array of strings
    public String getNewString(String originalString) {
        StringBuilder newString = new StringBuilder();
        String[] stringArr = originalString.split(" ");
        for (String s : stringArr) {
            if (s.contains("utilize")) {
                newString.append("use");
            } else {
                newString.append(s);
            }
            newString.append(" ");
        }
        return newString.toString();
    }
    //open the file where the original string is located
    public String getOriginalString() throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/main/java/ex45/exercise45_input.txt")));
    }

}