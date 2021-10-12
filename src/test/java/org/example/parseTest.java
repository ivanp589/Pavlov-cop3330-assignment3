package org.example;

import ex41.nameSort;

import ex42.Person;
import ex42.parseData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 ivan pavlov
 */

import static ex42.parseData.stringSort;
import static java.lang.System.out;
import static org.junit.Assert.assertEquals;

public class parseTest {
        @Test
        @DisplayName("create array")
        void parse_test1() throws IOException {
            parseData tester = new parseData();
            nameSort impor = new nameSort();

            BufferedReader br = new BufferedReader(new FileReader("src/main/java/ex42/exercise42_input.txt"));

            String[] array = impor.storeString(br,8);
            String[] test = stringSort(array,7);
            Person[] testint = tester.createEmpArray(7,test);
            //counts number of lines in original file
            StringBuilder sb = new StringBuilder();
            StringBuilder sb1 = new StringBuilder();

            Optional<Person> p = Arrays.stream(testint).findFirst();
            String sb1string = Arrays.stream(array).findFirst().toString();
            String[] sb1Str = sb1string.split(",");

            sb.append(p.get().getFirst());
            sb1.append(sb1Str[1]);
//            out.println(sb);
//            out.println(sb1);

            String actual = sb.toString();
            String expected = sb1.toString();
            assertEquals(expected,actual);
        }

    @Test
    @DisplayName("find longest")//since all find function work the same will not test each
    void parse_test2() throws IOException {
        parseData tester = new parseData();
        nameSort impor = new nameSort();

        BufferedReader br = new BufferedReader(new FileReader("src/main/java/ex42/exercise42_input.txt"));
        //i1 = num of lines-1,known
        String[] array = impor.storeString(br,8);
        String[] test = stringSort(array,7);
        Person[] testint = tester.createEmpArray(7,test);   //person array

        int longestname = 0;
        longestname = tester.FindLongest(testint,7,1);
//            out.println(longestname);
//            out.println();

        int actual = longestname;
        int expected = 8;//Geoffrey is the longest, known
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("createEmployee")//since all find function work the same will not test each
    void parse_test3() throws IOException {
        parseData tester = new parseData();
        nameSort impor = new nameSort();

        String p = "Pavlov,Ivan,40000";
        Person ivan = parseData.createEmployee(p);

        String actual = ivan.getFirst();
        String expected = "Ivan";
        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("sort test")//since all find function work the same will not test each
    void parse_test4() throws IOException {
        parseData tester = new parseData();
        nameSort impor = new nameSort();
        String[] testarr = {"acb","abc"};
        String[] sorted = stringSort(testarr,1);

        String actual = Arrays.toString(sorted);
        String[] expect = {"abc","acb"};
        String expected = Arrays.toString(expect);
        assertEquals(expected,actual);
    }
}
