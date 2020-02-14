package com.example.collections;

import com.example.collections.hackerrank.strings.CamelCase;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by John on 9/7/2016.
 */
public class CamelCaseUnitTest {

    @Test
    public void testCamelCase() throws Exception {
        String value = "saveChangesInTheEditor";

        int result = CamelCase.getAmountOfUpperCaseLetter(value);


        assertEquals(5, result);
    }
}
