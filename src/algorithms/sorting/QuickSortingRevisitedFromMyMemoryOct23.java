package algorithms.sorting;

import java.util.Arrays;

public class QuickSortingRevisitedFromMyMemoryOct23 {
    public static void main(String[] args) {
        int[] array = {7,0,11,3,22,4,9,6,15,1};
        System.out.println("Array before soring is: " + Arrays.toString(array));
        quickSort(array, 0, array.length-1);
        System.out.println("Array after soring is: " + Arrays.toString(array));
    }

    public static void quickSort(int[] arr, int startIndex, int endIndex){
        if(startIndex<endIndex){
            int basisIndex = computeBasis(arr, startIndex, endIndex);
            quickSort(arr, startIndex, basisIndex-1);
            quickSort(arr, basisIndex, endIndex);
        }
    }

    public static int computeBasis(int[] arr, int startIndex, int endIndex){
        int leftToRightRunner = startIndex;
        int rightToLeftRunner = endIndex;
        int basis = arr[startIndex + (endIndex-startIndex)/2];

        while(leftToRightRunner<=rightToLeftRunner){

            while(arr[leftToRightRunner]<basis)
                leftToRightRunner++;

            while(arr[rightToLeftRunner]>basis)
                rightToLeftRunner--;

            if(leftToRightRunner<=rightToLeftRunner){
                int tempExchangeVar = arr[leftToRightRunner];
                arr[leftToRightRunner] = arr[rightToLeftRunner];
                arr[rightToLeftRunner] = tempExchangeVar;
                leftToRightRunner++;
                rightToLeftRunner--;
            }
        }
        return leftToRightRunner;
    }
}
