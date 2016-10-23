package com.example.collections.hackerrank.strings;

import android.text.TextUtils;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by John on 9/4/2016.
 */
public class SuperReducedString {
    // aaabccddd

    public static String reduce(String str) {
        if (TextUtils.isEmpty(str)) return "Empty String";

        char[] charArray = str.toCharArray();
        for (int idx = 0; idx < charArray.length-1; idx++) {
            char current = charArray[idx];
            char next = charArray[idx + 1];
            if (current == next) {
                String redcudeStr = reduceString(charArray, idx, idx + 1);
                return reduce(redcudeStr);
            }
        }
        return new StringBuilder().append(charArray).toString();
    }

    public static String reduceString(char[] array, int idLeft, int idRight) {
        char[] result = new char[array.length - 2];
        char[] newArray = Arrays.copyOfRange(array, 0, idLeft);

        boolean isLastIndexIsFinal = (array.length - 1) == idRight;
        char[] newArraySecond = new char[0];
        if (!isLastIndexIsFinal) {
            newArraySecond = Arrays.copyOfRange(array, idRight + 1, array.length);
        }

        StringBuilder builder = new StringBuilder();
        builder.append(newArray);
        builder.append(newArraySecond);

        return builder.toString();
    }
}
