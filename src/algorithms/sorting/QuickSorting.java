package algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSorting {
    public static void main(String[] args) {
        int[] array = initializeArray(100);
        System.out.println("BEFORE SORT: " + Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println("AFTER  SORT: " + Arrays.toString(array));
    }

    private static int[] initializeArray(int size){
        int[] array = new int[size];
        Random random = new Random();
        for(int i=0; i<array.length-1;i++)
            array[i] = random.nextInt(100);
        return array;
    }

    private static void quickSort(int[] array, int start, int end){
        int leftIndex = start;
        int rightIndex = end;
        int basisIndex = start + (end-start)/2;
        int basisValue = array[basisIndex];
        while(leftIndex <= rightIndex) {
            while(array[leftIndex] < basisValue)
                leftIndex++;
            while(array[rightIndex] > basisValue)
                rightIndex--;
            if(leftIndex <= rightIndex) {
                int temp = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = temp;
                leftIndex++;
                rightIndex--;
            }
        }
        if(start < rightIndex)
            quickSort(array, start, rightIndex);
        if(end > leftIndex)
            quickSort(array, leftIndex, end);
    }
}
