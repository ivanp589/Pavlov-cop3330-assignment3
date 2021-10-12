package org.example;

import ex41.nameSort;
import ex42.Person;
import ex42.parseData;
import ex43.WebsiteMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;

public class websiteTest {
    @Test
    @DisplayName("check truth")
    void web_test1() throws IOException {
        WebsiteMaker tester = new WebsiteMaker();
        boolean test = tester.checkIftrue("y");

        boolean actual = test;
        boolean expected = true;
        assertEquals(true,actual);
    }

    @Test
    @DisplayName("check truth")
    void web_test2() throws IOException {
        WebsiteMaker tester = new WebsiteMaker();
        boolean test = tester.checkIftrue("n");

        boolean actual = test;
        boolean expected = false;
        assertEquals(false,actual);
    }

    @Test
    @DisplayName("file made?")
    void web_test3() throws IOException {
        WebsiteMaker tester = new WebsiteMaker();
        tester.createWebsite("ivan","ivan",false,false);
        File file =new File("user.dir/ivan");
//        boolean (file=null)
        boolean actual = (file==null);
        boolean expected = false;
        assertEquals(false,actual);
    }
}
