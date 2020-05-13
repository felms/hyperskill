import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] matrix = new int[n][m];

        //Lê a matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        int[][] rMatrix = new int[m][n];
        //Rotaciona a matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int k = Math.abs(i - n + 1);
                rMatrix[j][k] = matrix[i][j];
            }
        }
        
        //Imprime o resultado
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(rMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}