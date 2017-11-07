package com.sorting;

public class QuickSorting2 {
    static void sort(int[] array) {
        sorting(array, 0, array.length - 1);
    }

    private static void sorting(int[] array, int left, int right) {
        if (right <= left)
            return;
        int j = partition(array, left, right);
        sorting(array, left, j - 1);
        sorting(array, j + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int i = left;
        int j = right + 1;
        int obj = array[left];
        while (true) {
            while (array[++i] < obj) if (i == right) break;
            while (array[--j] > obj) if (j == left) break;

            if (i < j)
                SortingUtil.swap(array, i, j);
            else {
                SortingUtil.swap(array, left, j); //swap the array[j] with array[left], and jump out of the while loop
                break;
            }
        }
        return j; //pay attention: must be j, not i, because array[i] >= obj
    }

}
