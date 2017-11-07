package com.sorting;

public class MergeSortingDownTop {
    private static int[] arrayMerge;
    static void sort(int[] array) {
        int len = array.length;
        arrayMerge = new int[len];

        for (int i = 1; i < len; i *= 2) {
            for (int j = 0; j < len - i; j += 2*i) {
                merge(array, j, j+i-1,  Math.min(j+2*i-1, len-1));
            }
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {

        System.arraycopy(array, left, arrayMerge, left, right - left + 1);

        int i = left;
        int j = mid+1;

        for (int k = left; k <= right; k++) {
            if (i > mid) array[k] = arrayMerge[j++];
            else if (j > right) array[k] = arrayMerge[i++];
            else if (arrayMerge[i] < arrayMerge[j]) array[k] = arrayMerge[i++];
            else array[k] = arrayMerge[j++];
        }

    }
}
