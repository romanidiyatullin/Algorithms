package algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

public class MergeSorting {

    public static void main(String[] args) {
        int[] array = initializeArray(11);
        System.out.println("BEFORE SORTING: " + Arrays.toString(array));
        mergeSorting(array);
        System.out.println("RESULT IS     : " + Arrays.toString(array));
    }

    private static int[] initializeArray(int size){
        int[] array = new int[size];
        Random random = new Random();
        for(int i=0; i<array.length-1;i++)
            array[i] = random.nextInt(100);
        return array;
    }

    public static void mergeSorting(int[] array) {
        if(array.length==1)
            return;
        int mid = array.length/2;
        int[] leftArray  = new int[mid];
        int[] rightArray = new int[array.length-mid];

        for(int i = 0; i<leftArray.length; i++)
            leftArray[i] = array[i];

        for(int j = 0; j<rightArray.length; j++)
            rightArray[j] = array[mid+j];

        mergeSorting(leftArray);
        mergeSorting(rightArray);

        merge(leftArray,rightArray, array);
    }

    public static void merge(int[] leftArray, int[] rightArray, int[] targetArray){

        int leftArrayIndex   = 0;
        int rightArrayIndex  = 0;
        int targetArrayIndex = 0;

        boolean isLeftArrayNotYetMerged  = true;
        boolean isRightArrayNotYetMerged = true;

        int size = leftArray.length + rightArray.length;

//        System.out.println("leftArray is:");
//        System.out.println(Arrays.toString(leftArray));
//
//        System.out.println("rightArray is:");
//        System.out.println(Arrays.toString(rightArray));

        while(targetArrayIndex<size){

            if (isLeftArrayNotYetMerged && isRightArrayNotYetMerged)
            {
                if (leftArray[leftArrayIndex] < rightArray[rightArrayIndex]) {
                    targetArray[targetArrayIndex] = leftArray[leftArrayIndex];
                    leftArrayIndex++;
                    targetArrayIndex++;
                    if(leftArrayIndex==leftArray.length) isLeftArrayNotYetMerged = false;
                } else {
                    targetArray[targetArrayIndex] = rightArray[rightArrayIndex];
                    rightArrayIndex++;
                    targetArrayIndex++;
                    if(rightArrayIndex==rightArray.length) isRightArrayNotYetMerged = false;
                }
            }
            else {
                targetArray[targetArrayIndex] = isLeftArrayNotYetMerged? leftArray[leftArrayIndex]: rightArray[rightArrayIndex];
                leftArrayIndex++;
                rightArrayIndex++;
                targetArrayIndex++;
            }
        }

//        System.out.println("targetArray is:");
//        System.out.println(Arrays.toString(targetArray));
//        System.out.println("---------------");

    }
}
