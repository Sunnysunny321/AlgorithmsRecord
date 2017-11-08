package com.sorting;

class SelectionSorting {
    /**
     * selection sorting: select the min data back and swap with the front data
     */
    static void sort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[minIndex])
                    minIndex = j;
            }
            SortingUtil.swap(array, i, minIndex);
        }
    }

}
