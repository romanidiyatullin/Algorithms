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
        int i = start;
        int j = end;
        int basisIndex = start + (end-start)/2;
        int basisValue = array[basisIndex];
        while(i<=j) {
            while(array[i]<basisValue)
                i++;
            while(array[j]>basisValue)
                j--;
            if(i<=j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if(start<j)
            quickSort(array, start, j);
        if(end>i)
            quickSort(array, i, end);
    }
}
