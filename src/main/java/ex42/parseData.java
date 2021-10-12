package ex42;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static ex41.nameSort.NumLines;
import static ex41.nameSort.storeString;
import static java.lang.System.out;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 ivan pavlov
 */

public class parseData {

    public static void main(String[] args) throws Exception {
        //open the input file for use in other functions
        File file = new File("src/main/java/ex42/exercise42_input.txt");
        //find the number of lines to get the size of an array needed
        int i1 = NumLines(file);
        int i2 = i1 - 1;
        //read from the file this time and store those lines within a string array
        BufferedReader br = new BufferedReader(new FileReader(file));      //resets br to the start of the file bc it was altered
        String[] ST1 = storeString(br, i1);                         //by the function from ex41
        String[] st1 = stringSort(ST1, i2);
        //returns a sorted string by last name, well by first couple characters
        //this way a shorter name wont affect its ascii value

        //create an array of people, under the person class we created
        Person[] Perarr = createEmpArray(i1,st1);
        //determine longest string for each attribute of a person
        //first,last name and salary
        int Firstlength;      //finds longest of every type of input, first,last,salary
        int Lastlength;      //for formatting purposes
        int Salarylength;
        Firstlength = FindLongest(Perarr,i1,1);
        Lastlength = FindLongest(Perarr,i1,2);
        Salarylength = FindLongest(Perarr,i1,3);
        //print the final organized string
        formatPrint(Firstlength,Lastlength,Salarylength,i1,Perarr);
    }
    //create a function to determine each attribute with the most characters
    //can use switch statement to be able to reuse the same function
    //store and return the length of the longest attribute for all people
    public static int FindLongest(Person[] Perarr, int i1, int type) {
        int length =0;
        int a=0;
        switch (type){
            case 1:         //finds longest first name
                while(a<i1){
                if(length < Perarr[a].getFirst().length()){
                    length = Perarr[a].getFirst().length();
                }
                a++;
                }
            case 2:         //finds longest last name
                while(a<i1){
                if(length < Perarr[a].getLast().length()){
                    length = Perarr[a].getLast().length();
                }
                a++;
                }
            case 3:         //finds the longest salary line
                while(a<i1){
                if(length < Perarr[a].getSalary().length()){
                    length = Perarr[a].getSalary().length();
                }
                a++;
                }
    }return length;
    }
    //print the proper output with the proper formatting
    //first two lines should be simple, need to be
    //the size of all longest attributes added plus 3 for 3 extra spaces
    private static void formatPrint(int countFirst, int countLast, int countSalary,int i1,Person[] Perarr) {
        //build the first string that will be printed
        StringBuilder[] s = new StringBuilder[i1+2];
        {s[0]= new StringBuilder();
        s[0].append("First");
            while(s[0].length() != countFirst+1){
                s[0].append(" ");
            }

        s[0].append("Last");
            while(s[0].length()!= countFirst+1+countLast+1){
                s[0].append(" ");
            }

        s[0].append("Salary");
            while(s[0].length()!= countFirst+1+countLast+1+countSalary+1){
                s[0].append(" ");
            }
        out.println(s[0]);} //can print these strings after the fact
        //build second string that will be printed
        s[1] = new StringBuilder();
        while(s[1].length()!=s[0].length()){
            s[1].append("-");
        }
        out.println(s[1]);
        //build last strings that are based off the organized array with same number of spaces
        //determined by size of all largest attributes added plus 3
        for(int h=0;h<i1;h++){
            s[h+2] = new StringBuilder();
            s[h+2].append(Perarr[h].getFirst());
            while(s[h+2].length()<countFirst+1){
                s[h+2].append(" ");
            }
            s[h+2].append(Perarr[h].getLast());
            while(s[h+2].length()<countFirst+1+countLast+1){
                s[h+2].append(" ");
            }
            s[h+2].append(Perarr[h].getSalary());
            while(s[h+2].length()<countFirst+1+countLast+1+countSalary+1){
                s[h+2].append(" ");
            }
            out.println(s[h+2]);
        }
    }

    //create a person array from the ordered string so that it will be ready to go when printed
    public static Person[] createEmpArray(int i1, String[] st1) {
        Person[] employee = new Person[i1];
        for(int i=0;i<i1;i++){
            //for each string create a new person and store these people in an array
            employee[i] = createEmployee(st1[i]);
        }
        return employee;
    }

    //break apart the input string into 3 parts,firstname,lastname and salary
    //and with this information create a person
    //since we know last name is first on the string we can use that to write our code
    public static Person createEmployee(String line){
        StringBuilder last = new StringBuilder();
        StringBuilder first = new StringBuilder();
        StringBuilder salary = new StringBuilder();
        int count = 0;
        for(int i =0;i<line.length();i++){
            if(Character.isDigit(line.charAt(i))){
                salary.append(line.charAt(i));
            }
            else if(Character.isAlphabetic(line.charAt(i))&& count==0){
                last.append(line.charAt(i));
            }
            else if(Character.isAlphabetic(line.charAt(i))&& count==1){
                first.append(line.charAt(i));
            }
            else{
                count+=1;
            }
            }

        return new Person(first.toString(), last.toString(), salary.toString());
    }
    //sort the input strings so that we can create the array of people and print
    public static String[] stringSort(String[] st1, int i1) {
        for (int i = 0; i < i1; i++) {
            for (int j = 0; j < i1 ; j++) {
                for (int k = 0; k < 3; k++) {
                    char x = st1[j].charAt(k);
                    char y = st1[j + 1].charAt(k);
                    if (x > y) {
                        //when a character is smaller than the other it is swapped
                        //can only check a few characters because some names may be too short
                        String blemp = st1[j];
                        st1[j] = st1[j + 1];
                        st1[j + 1] = blemp;
                    }
                    if (st1[j].compareToIgnoreCase(st1[j + 1]) > 0) {
                        //when a string is smaller it is swapped, may be redundant but safe
                        String blemp1 = st1[j];
                        st1[j] = st1[j + 1];
                        st1[j + 1] = blemp1;
                    }
                }
                }}
            return st1;
        }
    }