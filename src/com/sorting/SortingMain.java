package com.sorting;



import static com.sorting.SortingUtil.*;

public class SortingMain {

    private final static int NUMBER = 100000;
    private final static int BOUND = 1 << 20; //2^30

    public static void main(String[] args) {

        int[] array = getRandomArray(NUMBER, BOUND);
        long timeStart = System.currentTimeMillis();

        //SelectionSorting.sort(array);
        //InsertionSorting.sort(array);
        //BubbleSorting.sort(array);
        MergeSorting.sort(array);


        long timeEnd = System.currentTimeMillis();

        assert isSorted(array); //VM options: -ea
        System.out.println("Time consumed: " + (timeEnd - timeStart) + "ms");

    }


}
