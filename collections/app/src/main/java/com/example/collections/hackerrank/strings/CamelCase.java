package com.example.collections.hackerrank.strings;

/**
 * Created by John on 9/7/2016.
 */
public class CamelCase {

    public static int getAmountOfUpperCaseLetter(final String input) {
        if (input == null || input.length() == 0) return 0;

        return input.split("[A-Z]+").length;
    }
}
