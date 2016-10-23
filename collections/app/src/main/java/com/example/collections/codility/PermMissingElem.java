package com.example.collections.codility;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by John on 10/6/2016.
 */
public class PermMissingElem {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int sum = (A.length + 1) * (A.length + 2) / 2;

        for (int idx = 0; idx < A.length; idx++) {
            sum -= A[idx];
        }

        return sum;
    }
}
