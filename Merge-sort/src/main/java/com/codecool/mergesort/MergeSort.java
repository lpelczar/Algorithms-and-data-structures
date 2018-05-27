package com.codecool.mergesort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    /**
     * Sorts the given List in place
     * @param listToSort the List to sort. Throws an error if its null
     */
    public void sort(List<Integer> listToSort) {
        if (listToSort == null) {
            throw new IllegalArgumentException("List is empty!");
        }
        mergesort(listToSort);
    }

    public void mergesort(List<Integer> listToSort) {
        if (listToSort.size() < 2) {
            return;
        }

        int mid = listToSort.size() / 2;
        List<Integer> left = new ArrayList<>(listToSort.subList(0, mid));
        List<Integer> right = new ArrayList<>(listToSort.subList(mid, listToSort.size()));

        mergesort(left);
        mergesort(right);
        mergeLists(left, right, listToSort);
    }

    private void mergeLists(List<Integer> left, List<Integer> right, List<Integer> listToSort) {
        int leftIndex = 0;
        int rightIndex = 0;
        int listToSortIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) < right.get(rightIndex)) {
                listToSort.set(listToSortIndex++, left.get(leftIndex++));
            } else {
                listToSort.set(listToSortIndex++, right.get(rightIndex++));
            }
        }
        while (leftIndex < left.size()) {
            listToSort.set(listToSortIndex++, left.get(leftIndex++));
        }
        while (rightIndex < right.size()) {
            listToSort.set(listToSortIndex++, right.get(rightIndex++));
        }
    }
}
