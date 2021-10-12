package ex46;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 ivan pavlov
 */

public class wordCounter {

    //get the input string and create a hashmap that stores the keyword and its frequency
    //which gets incremented every time it is found
    //create aformatted output given this frequency and keyword data
    public static void main(String[] args) {
        wordCounter counted = new wordCounter();

        String inputSTR = getStringFromFile();
        HashMap<String, Integer> frequencyHashMap = createHashMap(inputSTR);
        String outputString = output(frequencyHashMap,inputSTR);
        System.out.println(outputString);
    }

    //create a formatted output string using the frequency of words and Keyword data
    public static String output(HashMap<String, Integer> frequencyHashMap, String inputSTR) {
        StringBuilder outputString = new StringBuilder();
        for (int i = 0; i < frequencyHashMap.size(); i++) {
            ArrayList<String> word = getListOfKeys(inputSTR);
            outputString.append(word.get(i));
            outputString.append(":");
            outputString.append(getSpaces(word.get(i)));
            outputString.append(getStars(frequencyHashMap, word.get(i)));
            outputString.append("\n");
        }
        return outputString.toString();
    }
    //create a list of keys that are found within the input string
    //in order to print appropriate order of keys
    public static ArrayList<String> getListOfKeys(String input) {
        String[] inputSTR = input.split("\\s+");
        ArrayList<String> listOfKeys = new ArrayList<>();
        for (int i = 0; i < inputSTR.length; i++) {
            if (!listOfKeys.contains(inputSTR[i])) {
                listOfKeys.add(inputSTR[i]);
            }
        }
        return listOfKeys;
    }
    //add a star to the string wverytime the word is found within the file, basically a counter
    public static String getStars(HashMap<String, Integer> frequencyHashMap, String word) {
        StringBuilder stars = new StringBuilder();
        int numStars = frequencyHashMap.get(word);
        for (int i = 0; i < numStars; i++) {
            stars.append("*");
        }
        return stars.toString();
    }

    //to get formatted output use a value of spaces larger than largest word, in the future
    //implement findlongest function to have this be automatic
    //append a space as many times as nessecary to get equal spacing
    public static String getSpaces(String word) {
        StringBuilder spaces = new StringBuilder();
        int numSpaces = 10-word.length();
        for (int i = 0; i< numSpaces; i++) {
            spaces.append(" ");
        }
        return spaces.toString();
    }

    //open original file and read the string in order to have a string to compute freq
    public static String getStringFromFile() {
        String originalString = "";
        try {
            originalString = new String(Files.readAllBytes(Paths.get("src/main/java/ex46/exercise46_input.txt")));
        } catch (Exception e) {e.printStackTrace();}
        return originalString;
    }


    //create hashmap of all keywords and their frequency for ease of access
    //increment the frequency value when the word is found within the string
    public static HashMap<String, Integer> createHashMap(String inputSTR) {
        HashMap<String, Integer> frequencyMap = new HashMap<>();
        String[] input = inputSTR.split("\\s+");
        for (int i = 0; i < input.length; i++) {
            if (!frequencyMap.containsKey(input[i])) {
                frequencyMap.put(input[i], 1);
            } else {
                int count = frequencyMap.get(input[i]) + 1;
                frequencyMap.replace(input[i], count);
            }
        }
        return frequencyMap;
    }
}
