package com.sorting;


public class MergeSortingTopDown {

    private static int[] arrayMerge;

    static void sort(int[] array) {
        int len = array.length;
        arrayMerge = new int[len];
        sorting(array, 0, len - 1);
    }


    private static void sorting(int[] array, int left, int right) {
        if (left >= right)
            return;
        int mid = left + (right - left) / 2;
        sorting(array, left, mid);
        sorting(array, mid + 1, right);
        merge(array, left, mid, right);

    }

    private static void merge(int[] array, int left, int mid, int right) {
        //avoid to declare and create auxiliary array here
        System.arraycopy(array, left, arrayMerge, left, right - left + 1);

        int i = left;
        int j = mid + 1;

        for (int k = left; k <= right; k++) {
            if (i > mid)
                array[k] = arrayMerge[j++];
            else if (j > right)
                array[k] = arrayMerge[i++];
            else if (arrayMerge[i] < arrayMerge[j])
                array[k] = arrayMerge[i++];
            else
                array[k] = arrayMerge[j++];
        }

    }
}
