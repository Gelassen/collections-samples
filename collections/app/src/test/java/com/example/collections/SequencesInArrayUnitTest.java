package com.example.collections;

import com.example.collections.others.ArraysOperationsProvider;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class SequencesInArrayUnitTest {

    private ArraysOperationsProvider subject;

    @Before
    public void setUp() throws Exception {
        subject = new ArraysOperationsProvider();
    }

    @Test
    public void testSeqSeeker_onEmptyArray_nonNullValidResult() {
        List<Integer> array = Collections.emptyList();

        ArraysOperationsProvider.Pair result = subject.sequenceSeeker(array);

        assertEquals(Integer.valueOf(0), result.getSequenceLength());
        assertEquals(Integer.valueOf(0), result.getPosition());
    }

    @Test
    public void testSeqSeeker_onSingleArray_seqWithLengthOne() {
        List<Integer> array = new ArrayList<>();
        array.add(1);

        ArraysOperationsProvider.Pair result = subject.sequenceSeeker(array);

        assertEquals(Integer.valueOf(1), result.getSequenceLength());
        assertEquals(Integer.valueOf(0), result.getPosition());
    }

    @Test
    public void testSeqSeeker_onSingleSequence_seqWithLengthMoreThanOne() {
        List<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(4);

        ArraysOperationsProvider.Pair result = subject.sequenceSeeker(array);

        assertEquals(Long.valueOf(3), Long.valueOf(result.getSequenceLength()));
        assertEquals(Integer.valueOf(0), result.getPosition());
    }

    @Test
    public void testSeqSeeker_onTwoSequences_seqWithLargestLength() {
        List<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(4);
        array.add(1);
        array.add(2);

        ArraysOperationsProvider.Pair result = subject.sequenceSeeker(array);

        assertEquals(Integer.valueOf(3), result.getSequenceLength());
        assertEquals(Integer.valueOf(0), result.getPosition());
    }

    @Test
    public void testSeqSeeker_onThreeSequencesLargestInTheEnd_seqWithLargestLength() {
        List<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(4);
        array.add(1);
        array.add(2);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);

        ArraysOperationsProvider.Pair result = subject.sequenceSeeker(array);

        assertEquals(Integer.valueOf(4), result.getSequenceLength());
        assertEquals(Integer.valueOf(5), result.getPosition());
    }

    @Test
    public void testSeqSeeker_OnMultipleSingleSequences_seqWithSingleLength() {
        List<Integer> array = new ArrayList<>();
        array.add(20);
        array.add(11);
        array.add(10);
        array.add(4);
        array.add(2);

        ArraysOperationsProvider.Pair result = subject.sequenceSeeker(array);

        assertEquals(Integer.valueOf(1), result.getSequenceLength());
        assertEquals(Integer.valueOf(0), result.getPosition());
    }
}