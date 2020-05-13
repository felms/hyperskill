import java.util.Scanner;

class Star {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[][] matrix = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    matrix[i][j] = "*";
                } else if (i + j == n - 1) {
                    matrix[i][j] = "*";
                } else if (i == n / 2 || j == n / 2) {
                    matrix[i][j] = "*";
                } else {
                    matrix[i][j] = ".";
                }                
            }
        }

        print(matrix, n);

    }

    static void print(String[][] matrix, int size) {
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// 00 01 02 03 04

// 10 11 12 13 14

// 20 21 22 23 24

// 30 31 32 33 34

// 40 41 42 43 44