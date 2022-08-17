package algorithms.sorting;

import java.util.Arrays;

public class BubbleSorting {
    public static void main(String[] args) {
        int[] array = {1000,900,800,800,600,500,400,300,200,0};
        System.out.println("Iterations required: " + bubbleSort(array));
        printArray(array);
    }

    public static void printArray(int[] array){
        Arrays.stream(array).forEach(System.out::println);
        System.out.println();
    }

    public static int bubbleSort(int[] array){
        int iterations = 0;
        boolean isSorted = false;
        while(!isSorted){
            isSorted = true;
            for(int i = 0; i < array.length-1; i++){
                if(array[i]>array[i+1]){
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    isSorted = false;
                }
            }
            iterations++;
        }
        return iterations;
    }
}
