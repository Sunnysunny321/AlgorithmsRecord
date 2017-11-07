package com.sorting;

public class ShellSorting {
    static void sort(int[] array) {
        int len = array.length;

        int h = 1;
        while (3*h + 1 < len) h = 3*h + 1;

        while (h >= 1) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h && array[j] < array[j-h]; j -= h) {
                    SortingUtil.swap(array, j, j - h);
                }
            }
            h = h / 3;
        }

    }
}
