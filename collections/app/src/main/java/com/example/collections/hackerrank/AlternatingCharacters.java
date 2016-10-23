package com.example.collections.hackerrank;

import java.util.Scanner;

/**
 * Created by John on 10/22/2016.
 */
public class AlternatingCharacters {

    public void run(Scanner scanner) {
        int amount = Integer.valueOf(scanner.nextLine());
        for (int idx = 1; idx < amount; idx++) {
            String str = scanner.nextLine();
            int deletes = 0;
            if (str.length() == 0) {
                System.out.println(deletes);
            } else {
                char previous = str.charAt(0);
                for (int idxIn = 1; idxIn < str.length(); idxIn++) {
                    char current = str.charAt(idxIn);
                    if (current == previous) {
                        deletes++;
                    }
                    previous = current;
                }
                System.out.println(deletes);
            }

        }
        scanner.close();
    }
}
