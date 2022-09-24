package algorithms.sorting;

import java.util.Arrays;

public class QuickSortingFromMemoryIn17Min {
    public static void main(String[] args) {
        int[] arr = {24,0,5,1,7,11,9};
        quickSort(arr, 0, arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void quickSort(int[] array, int arrayStartIndex, int arrayEndIndex)
    {
        if(arrayStartIndex < arrayEndIndex) {
            int basisIndex = divide(array, arrayStartIndex, arrayEndIndex);
            quickSort(array, arrayStartIndex, basisIndex-1);
            quickSort(array, basisIndex, arrayEndIndex);
        }
    }

    public static int divide(int[] array, int from, int to){

        int basis = array[from + (to-from)/2];
        int leftIndex = from;
        int rightIndex = to;

        while (leftIndex <= rightIndex) {

            while(array[leftIndex] < basis)
                leftIndex++;

            while (array[rightIndex] > basis)
                rightIndex--;

            if(leftIndex <= rightIndex) {
                int temp = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = temp;
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }
}
