package com.codecool.quicksort;

import java.util.List;

import static java.util.Collections.swap;

public class QuickSort {

    /**
     * Sorts the given List in place
     * @param list the List to sort. Throws an error if its null
     */
    public void sort(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("List is empty!");
        }
        quicksort(list, 0, list.size() - 1);
    }

    private void quicksort(List<Integer> list, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = list.get(left + (right - left) / 2);
        int partitionPoint = partition(list, left, right, pivot);
        quicksort(list, left, partitionPoint - 1);
        quicksort(list, partitionPoint, right);
    }

    private int partition(List<Integer> list, int left, int right, int pivot) {
        while (left <= right) {
            while (list.get(left) < pivot) {
                left++;
            }

            while (list.get(right) > pivot) {
                right--;
            }

            if (left <= right) {
                swap(list, left, right);
                left++;
                right--;
            }
        }
        return left;
    }
}
