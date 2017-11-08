package com.sorting;




import java.util.Arrays;

import static com.sorting.SortingUtil.*;

public class SortingMain {

    private final static int NUMBER = 100000;
    private final static int BOUND = 1 << 1; //2^30

    public static void main(String[] args) {

        int[] array = getRandomArray(NUMBER, BOUND);
        long timeStart = System.currentTimeMillis();

        //BubbleSorting.sort(array);
        //SelectionSorting.sort(array);
        //InsertionSorting.sort(array);
        //ShellSorting.sort(array);
        //MergeSortingTopDown.sort(array);
        //MergeSortingDownTop.sort(array);
        //Arrays.sort(array);
        //QuickSorting2.sort(array);
        QuickSorting3.sort(array);



        long timeEnd = System.currentTimeMillis();

        assert isSorted(array); //VM options: -ea
        System.out.println("Time consumed: " + (timeEnd - timeStart) + "ms");

    }


}
