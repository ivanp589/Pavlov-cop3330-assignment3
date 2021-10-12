package ex41;
import java.io.*;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 ivan pavlov
 */

import static java.lang.System.out;

public class nameSort {

    public static void main(String[] args) throws Exception {
        //open file to start
        File file = new File("src/main/java/ex41/exercise41_input.txt");
        //count number of lines within the file to determine arrray size needed
        int lines = NumLines(file);
        int arSize = lines - 1;    //size of array
        //size of array is smaller than #lines bc it includes 0

        //read the contents of the file and store in a string array
        BufferedReader br = new BufferedReader(new FileReader(file));      //resets br to the start of the file bc it was altered
        String[] ST1 = storeString(br, lines);                         //by the previous function
        String[] st1 = stringSort(ST1, arSize);
        //create and print the output string to a file
        String created = create(st1, arSize);
        checkForError(created);
    }
    //check to see if file was created
    public static void checkForError(String created) {
        if (!created.equals("File created")){
            out.println("File not created");
        }
    }
        //create a new file to print the output string into
    private static String create(String[] st1, int arSize) {
        int lines = arSize + 1;
        try{
            File outfile = new File("src/main/java/ex41/exercise41_output.txt");
            //open the new file and write to it
            BufferedWriter outputWriter = new BufferedWriter(new FileWriter(outfile));
            outputWriter.write("Total of " + lines + " names\n");
            outputWriter.write("-----------------\n");
            //once formatting is out of the way
            //print each element of the array into the file
            for (int k = 0; k <= arSize; k++) {
                outputWriter.write(st1[k] + "\n");
            }
            //once done close the file and all other appropriate things
            outputWriter.flush();
            outputWriter.close();
            return "File created";
        }catch (Exception e) {
            e.printStackTrace();
            return "File not created";
        }
    }
// sort the array of strings found from the input file
    public static String[] stringSort(String[] st1, int lines) {
        for (int i = 0; i < lines ; i++) {
            for (int j = 0; j < lines ; j++) {
                //sort the strings with no attention to case
                //therefore all strings will be seen with a similar case and a case
                //wouldnt add any extra value to the calculation
                if (st1[j].compareToIgnoreCase(st1[j + 1]) > 0) {
                    //when a string is found that is smaller than the smallest string so far
                    //we swap it to make it the smallest sting so far
                    String blemp = st1[j];
                    st1[j] = st1[j + 1];
                    st1[j + 1] = blemp;
                }
            }
        }
        return st1;
    }
    //store the read array of stings somewhere
    public static String[] storeString(BufferedReader br, int lines) throws IOException {
        String[] st = new String[lines];       //reads every line of the file in reverse order and stores it in string
        int i =0;
        while (lines > i) {                        //array st
            st[i] = br.readLine();
            i++;
        }
        return st;
    }
        //calculate the number of lines in the input file to determine array size
        public static int NumLines(File file) throws IOException {
            BufferedReader br = new BufferedReader(new FileReader(file));
            int i = 0;
            {
                //keep reading lines and incrementing the counter untill you find a null line
                while ((br.readLine()) != null) {   //function counts the number of lines in the file
                    i++;}
            }return i;
        }
}