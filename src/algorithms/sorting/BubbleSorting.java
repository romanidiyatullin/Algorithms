package algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

public class BubbleSorting {
    public static void main(String[] args) {
        int[] array = initializeArray(100);
        System.out.println("Iterations required: " + bubbleSort(array));
        Arrays.stream(array).forEach(System.out::println);
    }

    private static int[] initializeArray(int size){
        int[] array = new int[size];
        Random random = new Random();
        for(int i=0; i<array.length-1;i++)
            array[i] = random.nextInt(100);
        return array;
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
