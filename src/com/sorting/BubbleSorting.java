package com.sorting;

import com.sorting.SortingUtil.*;

public class BubbleSorting {

    static void sort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] > array[j+1])
                    SortingUtil.swap(array, j, j+1);
            }
        }
    }
}
