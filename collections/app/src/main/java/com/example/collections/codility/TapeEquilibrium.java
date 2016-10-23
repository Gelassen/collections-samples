package com.example.collections.codility;

import android.util.Log;

import com.example.collections.App;

import java.util.Arrays;

/**
 *

 A non-empty zero-indexed array A consisting of N integers is given. Array A represents numbers on a tape.

 Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

 The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

 In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

 For example, consider array A such that:
 A[0] = 3
 A[1] = 1
 A[2] = 2
 A[3] = 4
 A[4] = 3

 We can split this tape in four places:

 P = 1, difference = |3 − 10| = 7
 P = 2, difference = |4 − 9| = 5
 P = 3, difference = |6 − 7| = 1
 P = 4, difference = |10 − 3| = 7

 Write a function:

 class Solution { public int solution(int[] A); }

 that, given a non-empty zero-indexed array A of N integers, returns the minimal difference that can be achieved.

 For example, given:
 A[0] = 3
 A[1] = 1
 A[2] = 2
 A[3] = 4
 A[4] = 3

 the function should return 1, as explained above.

 Assume that:

 N is an integer within the range [2..100,000];
 each element of array A is an integer within the range [−1,000..1,000].

 Complexity:

 expected worst-case time complexity is O(N);
 expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).

 Elements of input arrays can be modified.

 *
 * Created by John on 10/6/2016.
 */
public class TapeEquilibrium {

    public int solution(int[] A) {
        // write your code in Java SE 8
        CorrectSolver solver = new CorrectSolver(A);
        solver.run();
        return solver.getResult();
    }

    public class CorrectSolver {
        int[] array;
        int minimum;

        public CorrectSolver(int[] array) {
            this.array = array;
            this.minimum = Integer.MAX_VALUE;
        }

        public int getResult() {
            return minimum;
        }

        public void run() {
            final int total = calculateSum();
            int left = 0;
            int right;
            for (int idx = 0; idx < array.length - 1; idx++) { // we should not cover right element
                left += array[idx];
                right = total - left;

                int delta = Math.abs(left - right);
                if (minimum > delta) {
                    minimum = delta;
                }
            }
        }

        public int calculateSum() {
            int result = 0;
            for (int idx = 0; idx < array.length; idx++) {
                result += array[idx];
            }
            return result;
        }
    }

    public class WrongSolver {
        private static final int NOT_INIT = -1;

        int[] array;
        int minimum;

        public WrongSolver(int[] array) {
            this.array = array;
            this.minimum = NOT_INIT;
        }

        public int getResult() {
            return minimum;
        }

        public void run(final int pivot) {
            Log.d(App.TAG, "Solver starts new cycle" );
            if (pivot >= array.length) return;

            int[] left = Arrays.copyOfRange(array, 0, pivot);
            int[] right = Arrays.copyOfRange(array, pivot,  array.length);

            final int leftSum = getSumOfElements(left);
            final int rightSum = getSumOfElements(right);
            final int newMinimum = calculateMinimum(leftSum, rightSum);
            initMinimumIfNeeded(newMinimum);
            if (isMinimumReached(newMinimum)) return;
            minimum = newMinimum;

            boolean isLeftBigger = isLeftIsBigger(getSumOfElements(left), getSumOfElements(right));
            run(isLeftBigger ? pivot - 1 : pivot + 1);
        }

        public boolean isLeftIsBigger(final int left, final int right) {
            return left > right;
        }

        public int getSumOfElements(final int[] arrayPart) {
            int result = 0;
            for (int idx = 0; idx < arrayPart.length; idx++) {
                result += arrayPart[idx];
            }
            return result;
        }

        public int calculateMinimum(final int left, final int right) {
            return Math.abs(left - right);
        }

        public boolean isMinimumReached(final int currentMin) {
            return minimum < currentMin;
        }

        public void initMinimumIfNeeded(int newMinimum) {
            if (minimum == NOT_INIT) minimum = newMinimum;
        }
    }

}
