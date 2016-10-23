package com.example.collections.hackerrank;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by John on 10/23/2016.
 */
public class Chessboard {

    static int solve(String[] input) {
        // look through all columns and calculate the longest pattern and 2 common sign
        // identify where the first sign for first character in the first row
        HashMap<String, Integer> map = new HashMap<>();
        for (int idx = 0; idx < input.length; idx++) {
            String str = input[idx];
            char[] arr = str.toCharArray();
            getMinimum(str, map);
        }

        String[] pattern = getChessboardValues(map);
        for (int idx = 0; idx < input.length; idx++) {
            String str = input[idx];
            char[] arr = str.toCharArray();
            getMinimum(str, map);
        }

        return -1;
    }

    static String[] getChessboardValues(HashMap<String, Integer> vocabulary) {
        Iterator<Map.Entry<String, Integer>> iterator = vocabulary.entrySet().iterator();
        Map.Entry<String, Integer> firstMax = null;
        Map.Entry<String, Integer> secondMax = null;
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (firstMax == null) {
                firstMax = entry;
            } else if (secondMax == null) {
                secondMax = entry;
            } else if (firstMax.getValue() < entry.getValue()){
                firstMax = entry;
            } else if (secondMax.getValue() < entry.getValue()) {
                secondMax = entry;
            }
        }

        return new String[] { firstMax.getKey(), secondMax.getKey() };
    }

    static HashMap<String, Integer> getMinimum(String str, HashMap<String, Integer> vocabulary) {
//        HashMap<String, Integer> result = new HashMap<>();
        char[] arr = str.toCharArray();
        for (int idx = 0; idx < arr.length; idx++) {
            char element = arr[idx];
            if (vocabulary.containsKey(element)) {
                int amount = vocabulary.get(element);
                vocabulary.put(String.valueOf(element), amount);
            } else {
                vocabulary.put(String.valueOf(element), 1);
            }
        }

        return vocabulary;
    }
}
