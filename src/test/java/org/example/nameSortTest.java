package org.example;

import ex41.nameSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 ivan pavlov
 */


public class nameSortTest {
    @Test
    @DisplayName("numb lines")
    void sort_test1() throws IOException {
        new nameSort();

        int test = nameSort.NumLines(new File("src/main/java/ex41/exercise41_input.txt"));
        //counts number of lines in original file
        int expected = 8;
        Assertions.assertEquals(expected, test);
    }

    @Test
    @DisplayName("storestringtest")
    void sort_test2() throws IOException {
        new nameSort();
        BufferedReader br = new BufferedReader(new FileReader("src/test/java/org/example/stingTestFile"));

        String[] test = nameSort.storeString(br,2);
        //counts number of lines in original file
        String[] expected = {"acb","abc"};
        String actualString = Arrays.toString(test);
        String expectedString = Arrays.toString(expected);
        Assertions.assertEquals(actualString,expectedString);

    }
    @Test
    @DisplayName("sort stringtest")
    void sort_test3() throws IOException {
        new nameSort();
        BufferedReader br = new BufferedReader(new FileReader("src/test/java/org/example/stingTestFile"));

        String[] array = nameSort.storeString(br,2);
        //counts number of lines in original file
        String[] actual = nameSort.stringSort(array,1);
        String[] expected = {"abc","acb"};
        String actualString = Arrays.toString(actual);
        String expectedString = Arrays.toString(expected);

        Assertions.assertEquals(expectedString,actualString);
    }

}
