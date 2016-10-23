package com.example.collections.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by John on 10/23/2016.
 */
public class Seats {

    public void testRun() {
//        X 42 13 17 23
//        11 13 X 10 10
//        14 12 15 X X
//        16 17 10 11 19
//        X X X X X
//        X 14 17 X 14
        String[] rows = new String[] {
            "X 42 13 17 23",
            "11 13 X 10 10",
            "14 12 15 X X",
            "16 17 10 11 19",
                "X X X X X",
                "X 14 17 X 14"
        };
        int minimum = Integer.MAX_VALUE;
        // understand minimum on each row
        for (int idx = 0; idx < rows.length; idx++) {
            String line = rows[idx];
            // read three tokens
            // if X found, skip this S-length set
            // use X + 1 index to read next S-length set of tokens
            // if there are no S-length set of token, skip this set
            // calculate the min for each set and update result if current minimum is less then previous
            minimum = getMinimum(line, 3, 5);

        }

        System.out.println(minimum == Integer.MAX_VALUE ? "IMPOSSIBLE" : minimum);
    }

    public void run() {
        // read lines
        Scanner scanner = new Scanner(System.in);
        Integer seatsLength = Integer.valueOf(scanner.nextLine());
        String dimensions = scanner.nextLine();
        String[] dimens = dimensions.split(" ");

        final int rows = Integer.parseInt(dimens[0]);
        final int columns = Integer.parseInt(dimens[1]);
        int minimum = Integer.MAX_VALUE;
        // understand minimum on each row
        for (int idx = 0; idx < rows; idx++) {
            String line = scanner.nextLine();
            // read three tokens
            // if X found, skip this S-length set
            // use X + 1 index to read next S-length set of tokens
            // if there are no S-length set of token, skip this set
            // calculate the min for each set and update result if current minimum is less then previous
            int localMinimum = getMinimum(line, seatsLength, columns);
            minimum = minimum > localMinimum ? localMinimum : minimum;
        }

        System.out.println(minimum == Integer.MAX_VALUE ? "IMPOSSIBLE" : minimum);
    }

    public static int getMinimum(String line, Integer seatsLength, int columns) {
        final String unavailable = "X";
        final String[] result = line.split(" ");
        int counter = 0;
        int currentMin = 0;
        int min = Integer.MAX_VALUE;
        int prevIdx = 0;
        for (int idx = 0; idx < columns; idx++) {
            String current = result[idx];
            if (current.equals(unavailable)) {
                counter = 0;
                currentMin = 0;
                prevIdx++;
                idx = prevIdx;
                continue;
            }

            counter++;
            currentMin += Integer.valueOf(current);
            if (counter == seatsLength) {
                min = currentMin < min ? currentMin : min;
                counter = 0;
                currentMin = 0;
                prevIdx++;
                idx = prevIdx - 1;
            }
        }
        return min;
    }

}
