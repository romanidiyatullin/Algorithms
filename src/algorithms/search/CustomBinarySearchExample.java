package algorithms.search;

/*
@RI 2022/08/11
Let's pretend we are not aware about existence of Arrays..methods. :)
Just to better understand how it works  - let's try this algorithm on practice!
*/

import java.util.InputMismatchException;
import java.util.Scanner;

class CustomBinarySearchExample {
    private Scanner scanner;
    private int arraySize;  // no need to explicitly assign since by default will be 0
    private int findThis;   // no need to explicitly assign since by default will be 0
    private int iterations; // no need to explicitly assign since by default will be 0
    private int index;      // no need to explicitly assign since by default will be 0
    private int[] array;    // no need to explicitly assign since by default will be null
    private boolean isElementDetected; // no need to explicitly assign since by default will be false

    private CustomBinarySearchExample(){
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        new CustomBinarySearchExample().start();
    }

    private void start(){
        System.out.println("CustomBinarySearchExample. \n" +
                "User provides: \n" +
                "1. array length. \n" +
                "2. int value for search in array. \n" +
                "Program outputs: \n" +
                "1. index of array element that holds desired value  or -1 if no such element.\n" +
                "2. number of required iterations to find provided int value.\n");

        takeUserInput();
        populateArray();
        compute();
        printResult();
    }

    private void takeUserInput() {
        try {
            System.out.println("Please enter length (as int) for array:");
            arraySize = scanner.nextInt();
            System.out.println("Please enter int value for search:");
            findThis = scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println("User input error. Please try again. Use int (integer values) for your input.");
            scanner.nextLine();
            takeUserInput();
        }
    }

    private void populateArray(){
        System.out.println("Array size is: " + arraySize);
        System.out.println("Value to search is: " + findThis);
        System.out.println("Populating array");
        array = new int[arraySize];
        // NOTE: Given array must be sorted in order for binarySearch to work, thus we can afford to populate array this way:
        for(int i =0; i<arraySize; i++) {
            array[i] = i + 1;
        }
    }

    private void compute() {
        int leftBorderIndex = 0;
        int rightBorderIndex = arraySize-1;
        int middle = 0;

        while (!isElementDetected && (leftBorderIndex <= rightBorderIndex))
        {
            iterations++;
            middle = leftBorderIndex + (rightBorderIndex - leftBorderIndex) / 2;
            if(array[middle] == findThis){
                isElementDetected = true;
                index = middle;
                System.out.println("SUCCESS! SUCCESS! SUCCESS! Element detected!");
            }
            else if (array[middle] > findThis)
            {
                rightBorderIndex = middle-1;
            }
            else if (array[middle] < findThis)
            {
                leftBorderIndex = middle+1;
            }
        }

    }

    private void printResult(){
        System.out.println("RESULTS. Did we find index for provided value? " + isElementDetected + "\n"
                +"Iterations conducted: " + iterations);
        if(isElementDetected)
            System.out.println("Index is: " + index);
    }
}
