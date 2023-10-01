package algorithms.search;

public class BinarySearchFromMyMemoryOct23 {
    static int searchAttempts = 0;

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        System.out.println("Attempts: " + binarySearchRecursion(array,15 , 0, array.length-1));
        System.out.println("Attampts: " + binarySearchLoop(array, 4));
    }

    public static int binarySearchRecursion(int[] arr, int number, int startIndex, int endIndex) {

        if(startIndex>endIndex)
            return -searchAttempts;

            int midIndex = startIndex + (endIndex - startIndex) / 2;
            searchAttempts++;

            if (arr[midIndex] == number) {
                System.out.println("Recursion method binarySearchRecursion. Number " + number + " detected at position index: " + midIndex);
                return searchAttempts;
            }

            if (arr[midIndex] < number) {
                return binarySearchRecursion(arr, number, midIndex + 1, endIndex);
            }
            else {
                return binarySearchRecursion(arr, number, startIndex, midIndex - 1);
            }
    }


    public static int binarySearchLoop(int[] arr, int number){
        int startIndex = 0;
        int endIndex = arr.length-1;
        int attempts = 0;
        while(startIndex<=endIndex){
            int midIndex = startIndex + (endIndex-startIndex)/2;
            attempts++;
            if(arr[midIndex]==number) {
                System.out.println("Loop method binarySearchLoop. Number " + number + " detected at position index: " + midIndex);
                return attempts;
            }
            if(arr[midIndex]<number) startIndex = midIndex+1;
            else endIndex = midIndex-1;
        }
        return -attempts;
    }
}
