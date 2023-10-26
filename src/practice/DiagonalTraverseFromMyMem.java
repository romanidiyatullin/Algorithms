package practice;

import java.util.Arrays;

public class DiagonalTraverseFromMyMem {

    public static int[] findDiagonalOrder(int[][] mat) {

        if(mat == null || mat.length == 0 || mat[0].length == 0)
            return new int[0];

        int N = mat.length;
        int M = mat[0].length;

        int[] res = new int[N*M];

        int r = 0;

        int row = 0;
        int col = 0;

        boolean isGoingUp = true;

        while(row<N && col<M){

            res[r++] = mat[row][col];
            int newrow;
            int newcol;

            if(isGoingUp){
                newrow = row-1;
                newcol = col+1;
            }
            else{
                newrow = row+1;
                newcol = col-1;
            }
            if(newrow==N || newrow<0 || newcol==M || newcol<0){
                if(isGoingUp){
                    if(col == M-1) {
                        row = row + 1;
                        col = col;
                    }
                    if(col<M-1) {
                        col = col + 1;
                        row = row;
                    }
                }
                else {
                    if(row==N-1) {
                        col = col + 1;
                        row = row;
                    }
                    if(row<N-1) {
                        row = row + 1;
                        col = col;
                    }
                }
                isGoingUp=!isGoingUp;
            }
            else {
                row = newrow;
                col = newcol;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}})));
        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}})));
        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{{1,2,3},{4,5,6}})));
        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}})));
        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{{1,2},{3,4},{5,6},{7,8}})));
        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{{1,2},{3,4}})));
        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{{1,2}})));
        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{{1}})));
    }
}
