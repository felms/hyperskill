import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class Spiral {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] matrix = createSpiral(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] createSpiral(int n) {
        int up = 0;
        int down = 1;
        int left = 2;
        int right = 3;

        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= n * n; i++) {
            numbers.add(i);
        }

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }
        
        int row = 0;
        int column = 0;
        int direction = right;

        while (!numbers.isEmpty()) {

            if (direction == right) {
                while (column < n && matrix[row][column] == 0) {
                    matrix[row][column] = numbers.remove(0);
                    column++;
                }

                column--;
                row++;
                direction = down;
            }

            if (direction == down) {
                while (row < n && matrix[row][column] == 0) {
                    matrix[row][column] = numbers.remove(0);
                    row++;
                }
                
                row--;
                column--;
                direction = left;
            }

            if (direction == left) {
                while (column >= 0 && matrix[row][column] == 0) {
                    matrix[row][column] = numbers.remove(0);
                    column--;
                }
                
                column++;
                row--;
                direction = up;
            }

            if (direction == up) {
                while (row >= 0 && matrix[row][column] == 0) {
                    matrix[row][column] = numbers.remove(0);
                    row--;
                }
                
                row++;
                column++;
                direction = right;
            }
        }

        return matrix;
    }
}