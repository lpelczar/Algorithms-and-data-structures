package com.codecool.mergesort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class MergeSortTest {

    @Test
    void sortingNullThrowsError() {
        MergeSort mergeSort = new MergeSort();
        assertThrows(IllegalArgumentException.class, ()-> mergeSort.sort(null));
    }

    @Test
    void sortingSimpleItemsWorks() {
        MergeSort mergeSort = new MergeSort();

        List<Integer> toSort = Arrays.asList(5, 3, 1, 12, 9);
        mergeSort.sort(toSort);

        List<Integer> expected = Arrays.asList(1, 3, 5, 9, 12);
        assertIterableEquals(expected, toSort);
    }

    @Test
    void sortingDuplicateItemsWorks() {
        MergeSort mergeSort = new MergeSort();

        List<Integer> toSort = Arrays.asList(5, 3, 1, 5, 9);
        mergeSort.sort(toSort);

        List<Integer> expected = Arrays.asList(1, 3, 5, 5, 9);
        assertIterableEquals(expected, toSort);
    }

    @Test
    void sortingOneItemWorks() {
        MergeSort mergeSort = new MergeSort();

        List<Integer> toSort = Arrays.asList(2);
        mergeSort.sort(toSort);

        List<Integer> expected = Arrays.asList(2);
        assertIterableEquals(expected, toSort);
    }
}