package org.example;

import com.google.gson.JsonObject;
import ex44.Product;
import ex44.productSearch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 ivan pavlov
 */
import static org.junit.Assert.assertEquals;

public class productTest {
    @Test
    @DisplayName("file opened?")
    void search_test1() throws IOException {
        productSearch tester = new productSearch();
        JsonObject opened = tester.openjson();
        boolean actual = (opened==null);
        boolean expected = false;
        assertEquals(false,actual);
    }
    @Test
    @DisplayName("Map created?")
    void search_test2() throws IOException {
        productSearch tester = new productSearch();
        JsonObject opened = tester.openjson();
        HashMap<String, Product> products =tester.createHash(opened);
        boolean prod = products.containsKey("Widget");

        boolean actual = (prod);
        boolean expected = true;
        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("in system?")
    void search_test3() throws IOException {
        productSearch tester = new productSearch();
        JsonObject opened = tester.openjson();
        HashMap<String, Product> products =tester.createHash(opened);
        boolean test = tester.isProductInSystem("Widget",products);


        boolean actual = test;
        boolean expected = true;
        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("output")
    void search_test4() throws IOException {
        productSearch tester = new productSearch();
        JsonObject opened = tester.openjson();
        HashMap<String, Product> products =tester.createHash(opened);
//        boolean test = tester.isProductInSystem("Widget",products);
        String out = tester.output(products,"Widget");
        String str1 = "Name: Widget\nPrice: 25.0\nQuantity: 5";
        String actual = out;
        String expected = str1;
        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("capital")
    void search_test5() throws IOException {
        productSearch tester = new productSearch();
        String test = tester.productCapilization("widget");
        String actual = test;
        String expected = "Widget";
        assertEquals(expected,actual);
    }


}
