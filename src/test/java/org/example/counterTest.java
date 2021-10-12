package org.example;

import ex45.wordFinder;
import ex46.wordCounter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 ivan pavlov
 */
public class counterTest {
    @Test
    @DisplayName("test output")//
    void counter_test1() throws IOException {
        wordCounter tester = new wordCounter();
        HashMap test = tester.createHashMap("bear bear bear");
        String actual = tester.output(test,"bear bear bear");
        String expected = "bear:      ***\n";

        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("create hash")//
    void counter_test2() throws IOException {
        wordCounter tester = new wordCounter();
        HashMap test = tester.createHashMap("bear bear bear");
        boolean actual = test!=null;
        Boolean expected = true;

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("keys test")//could test for a key that doesnt exist
    void counter_test3() throws IOException {
        wordCounter tester = new wordCounter();
        ArrayList<String> test = tester.getListOfKeys("bear bear bear");
        String actual = test.get(0);
        String expected = "bear";

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("test number of stars")//
    void counter_test4() throws IOException {
        wordCounter tester = new wordCounter();
        HashMap test = tester.createHashMap("bear bear bear");
        String actual = tester.getStars(test,"bear");
        String expected = "***";

        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("test number of spaces")//
    void counter_test5() throws IOException {
        wordCounter tester = new wordCounter();
        String actual = tester.getSpaces("bear");
        String expected = "      ";

        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("test if input is opened")//
    void counter_test6() throws IOException {
        wordCounter tester = new wordCounter();
        String test = tester.getStringFromFile();
        boolean actual = test!=null;
        boolean expected = true;

        assertEquals(expected,actual);
    }

}
