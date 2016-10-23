package com.example.collections.codility;

import android.util.Log;

import com.example.collections.App;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *

 Write a function:

 class Solution { public int solution(int[] A); }

 that, given a non-empty zero-indexed array A of N integers, returns the minimal positive integer (greater than 0) that does not occur in A.

 For example, given:
 A[0] = 1
 A[1] = 3
 A[2] = 6
 A[3] = 4
 A[4] = 1
 A[5] = 2

 the function should return 5.

 Assume that:

 N is an integer within the range [1..100,000];
 each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].

 Complexity:

 expected worst-case time complexity is O(N);
 expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).

 Elements of input arrays can be modified.


 * Created by John on 10/7/2016.
 */
public class FindMinValueInLine {

    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);

        int minimal = 0;
        for (int idx = 0; idx < A.length; idx++) {
            minimal = A[idx] - minimal;
            if (minimal != 1) return minimal;
        }

        return minimal;
    }

}
