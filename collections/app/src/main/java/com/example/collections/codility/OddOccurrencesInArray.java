package com.example.collections.codility;

import java.util.HashSet;

/**
 * Created by John on 10/6/2016.
 */
public class OddOccurrencesInArray {

    public static void main(String[] args) {


    }

    public int solution(int[] A) {
        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return A[0];

        // write your code in Java SE 8
        HashSet<Element> hashSet = new HashSet<>();
        for (int id = 0; id < A.length; id++) {
            int item = A[id];

            Element element = new Element(A[id], id);
            boolean isNewElement = hashSet.add(element);
            if (!isNewElement) hashSet.remove(element);
        }

        Element[] content = new Element[1];
        hashSet.toArray(content);
        return content[0].number;
    }

    public static class Element {
        private final int number;
        private final int position;

        public Element(int number, int position) {
            this.number = number;
            this.position = position;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Element element = (Element) o;

            // check only numbers
            return number == element.number;
        }

        @Override
        public int hashCode() {
            int result = number;
            result = 31 * result /*+ position*/;
            return result;
        }
    }
}
