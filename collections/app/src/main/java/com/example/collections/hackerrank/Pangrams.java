package com.example.collections.hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by John on 10/23/2016.
 */
public class Pangrams {

    public void run() {
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine().trim().toLowerCase();
        String input = "We promptly judged antique ivory buckles for the prize".replaceAll("\\s","").toLowerCase();

        char[] asChars = input.toCharArray();
        Set<Character> characters = new HashSet<>();
        for (int idx = 0; idx < asChars.length; idx++) {
            characters.add(asChars[idx]);
        }

        final int range = (int) 'z' - (int) 'a';
        System.out.println(characters.size() == range ? "pangram" : "not pangram");
    }
}
