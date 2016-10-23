package com.example.collections.hackerrank;

import java.util.Scanner;

/**
 * Created by John on 9/4/2016.
 */
public class RotationArray {

//    public static int[] runTest(int spaceSize,
//                                int rotationSize, int queriesSize) {
//        int[] space = buildSpace(spaceSize, in);
//        int[] queries = buildQueries(queriesSize, in);
//
//        int shift = getShift(spaceSize, rotationSize);
//        int[] newSpace = rotateSpace(shift, space);
//
//        final int size = space.length;
//        for (int idx = 0; idx < size; idx++) {
//            int query = queries[idx];
//            System.out.println("" + newSpace[query]);
//        }
//    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int spaceSize = Integer.valueOf(in.next());
        int rotationSize = Integer.valueOf(in.next());
        int queriesSize = Integer.valueOf(in.next());

        int[] space = buildSpace(spaceSize, in);
        int[] queries = buildQueries(queriesSize, in);

        int shift = getShift(spaceSize, rotationSize);
        int[] newSpace = rotateSpace(shift, space);

        final int size = space.length;
        for (int idx = 0; idx < size; idx++) {
            int query = queries[idx];
            System.out.println("" + newSpace[query]);
        }
    }

    public static int[] rotateSpace(int shift, int[] space) {
        int[] result = new int[space.length];
        for (int idx = 0; idx < space.length; idx++) {
            int newIdx = idx + shift;
            newIdx = newIdx >= space.length ? newIdx - space.length : newIdx;
            result[newIdx] = space[idx];
        }
        return result;
    }

    public static int[] buildSpace(int size, Scanner in) {
        int[] result = new int[size];
        for (int idx = 0; idx < size; idx++) {
            result[idx] = Integer.valueOf(in.next());
        }
        return result;
    }

    public static int[] buildQueries(int size, Scanner in) {
        int[] result = new int[size];
        for (int idx = 0; idx < size; idx++) {
            result[idx] = Integer.valueOf(in.next());
        }
        return result;
    }

    public static int getShift(final int size, final int rotation) {
        if (size > rotation) return rotation;

        int temp = rotation;
        while (temp > size) {
            temp -= size;
        }
        return temp;
    }

}
