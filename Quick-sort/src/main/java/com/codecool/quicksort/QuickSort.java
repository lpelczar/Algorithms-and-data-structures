package com.codecool.quicksort;

import java.util.List;

public class QuickSort {

    /**
     * Sorts the given List in place
     * @param list the List to sort. Throws an error if its null
     */
    public void sort(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("List is empty!");
        }
    }
}
