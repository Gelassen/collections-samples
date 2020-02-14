package com.example.collections.others;

import java.util.Iterator;
import java.util.List;

public class ArraysOperationsProvider {

    private static final int NO_POSITION = 0;

    public Pair sequenceSeeker(List<Integer> array) {
        if (array == null) return new Pair(0, NO_POSITION);
        if (array.size() == 0) return new Pair(0, NO_POSITION);

        Pair longestSequence = new Pair(0, NO_POSITION);
        Pair previousPair = new Pair(0, NO_POSITION);
        while (array.size() > (previousPair.position + previousPair.sequenceLength)) {
            previousPair = findSequence(array, previousPair.position + previousPair.sequenceLength);
            if (longestSequence.sequenceLength < previousPair.sequenceLength) {
                longestSequence = previousPair;
            }
        }

        return longestSequence;
    }

    private Pair findSequence(List<Integer> array, int position) {
        int length = 0;
        int start = position;
        for (int idx = position; idx < array.size(); idx++) {
            length++;
            int current = array.get(idx);
            int nextIdx = idx + 1;
            boolean hasNext = array.size() > nextIdx;
            if (hasNext) {
                int next = array.get(nextIdx);
                if (current > next) {
                    return new Pair(length, start);
                }
            }
        }
        return new Pair(length, start);
    }

    public static class Pair {
        private Integer sequenceLength;
        private Integer position;

        public Pair(Integer sequenceLength, Integer position) {
            this.sequenceLength = sequenceLength;
            this.position = position;
        }

        public Integer getSequenceLength() {
            return sequenceLength;
        }

        public Integer getPosition() {
            return position;
        }
    }
}
