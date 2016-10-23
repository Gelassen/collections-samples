package com.example.collections.hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by John on 10/23/2016.
 */
public class Gemstones {

    public void run() {
        List<Set<Character>> result = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        Integer amount = Integer.valueOf(scanner.nextLine());
        for (int idx = 0; idx < amount; idx++) {
            String newLine = scanner.nextLine();
            Set<Character> set = new HashSet<>();
            char[] chs = newLine.toCharArray();
            for (int id = 0; id < newLine.length(); id++){
                set.add(chs[id]);
            }
            result.add(set);
        }

        Set<Character> maxSize = new HashSet<>();
        for (Set<Character> set : result) {
            maxSize = set.size() > maxSize.size() ? set : maxSize;
        }

        Set<Character> tree = new TreeSet<>(maxSize);
        for (Set<Character> sample : result) {
            tree.retainAll(sample);
        }

        System.out.println(tree.size());
    }
}
