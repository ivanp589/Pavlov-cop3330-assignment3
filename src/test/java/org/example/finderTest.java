package org.example;

import ex44.productSearch;
import ex45.wordFinder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class finderTest {
    @Test
    @DisplayName("original string is read")//
    void finder_test1() throws IOException {
        wordFinder tester = new wordFinder();
        boolean test = tester.getOriginalString()!=null;
        boolean actual = test;
        boolean expected = true;

        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("replacement test")//
    void finder_test2() throws IOException {
        wordFinder tester = new wordFinder();
        String test = tester.getNewString("utilize utilize");
        String actual = test;
        String expected = "use use ";

        assertEquals(expected,actual);
    }
}
