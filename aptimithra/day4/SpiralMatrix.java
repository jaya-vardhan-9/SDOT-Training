package aptimithra.day4;

import java.util.*;

class SpiralMatrix{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int  j=0;j<cols;j++){
                matrix[i][j]=sc.nextInt();
            }
        }

        printSpiralMatrix(matrix, rows, cols);
    }


    private static void printSpiralMatrix(int[][] matrix, int rows, int cols) {
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;
        
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
                }
                top++;
            for(int i = top;i<=bottom;i++){
                System.out.print(matrix[i][right]+" ");
            }
            right --;
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    System.out.print(matrix[bottom][j] + " ");
                }  
            bottom --;
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    System.out.print(matrix[i][left]+" ");
                }
            left ++;
            }
            }
}
    }

}