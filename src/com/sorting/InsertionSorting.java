package com.sorting;

public class InsertionSorting {
    static void sort(int[] array) {
        int len = array.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0 && array[j] < array[j-1]; j--) {
                SortingUtil.swap(array, j, j-1);
            }
        }
    }
}
