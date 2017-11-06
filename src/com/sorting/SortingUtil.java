package com.sorting;

import java.util.Random;

class SortingUtil {
    static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    static boolean isSorted(int[] array) {
        //VM options: -ea(open assert), default(close the assert)
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i+1])
                return false;
        }
        return true;
    }

    static int[] getRandomArray(int n, int max) {
        /**
         * @param n represents the size of array, max represents
         *         the bound value of the element in the array
         */
        Random rand = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(max);
        }
        return array;
    }

    static void printArray(int[] array) {
        System.out.print("array: [ ");
        for (Integer elem: array) {
            System.out.print(elem + " ");
        }
        System.out.println("]");
    }



}
