package data_structures.list.performance;

import algorithms.sorting.BubbleSorting;
import algorithms.sorting.QuickSorting;

import java.util.Arrays;
import java.util.Random;

public class TestSortingSpeed {
    public static void main(String[] args) {
        int[] array = initializeArray(10000);
        int[] array2 = Arrays.copyOf(array,10000);
        System.out.println("Quick Sorting took: ");
        testPerformance(()->QuickSorting.quickSort(array,0,array.length-1));
        System.out.println("Bubble Sorting took: ");
        testPerformance(()->BubbleSorting.bubbleSort(array2));
    }

    private static int[] initializeArray(int size){
        int[] array = new int[size];
        Random random = new Random();
        for(int i=0; i<array.length-1;i++)
            array[i] = random.nextInt(100);
        return array;
    }

    private static long testPerformance(Runnable runnable){
        long startTime = System.currentTimeMillis();
        runnable.run();
        long endTime = System.currentTimeMillis();
        long result = endTime-startTime;
        System.out.println(result);
        return result;
    }
}
