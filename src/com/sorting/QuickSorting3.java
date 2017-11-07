package com.sorting;

public class QuickSorting3 {
    //apply to array which has many repeat
    static void sort(int[] array) {
        sorting(array, 0, array.length - 1);
    }

    private static void sorting(int[] array, int left, int right) {

        if (right <= left)
            return;

        int lt = left;
        int gt = right;
        int i = left + 1;
        int obj = array[lt];
        while (i <= gt) {
            if (obj > array[i]) {
                SortingUtil.swap(array, lt, i);
                lt++; i++;
            } else if (obj < array[i]) {
                SortingUtil.swap(array, gt, i);
                gt--;
            } else {
                i++;
            }
        }
        sorting(array, left, lt - 1);
        sorting(array, gt + 1, right);
    }
}
