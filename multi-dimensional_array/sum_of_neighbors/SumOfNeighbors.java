import java.util.List;
import java.util.ArrayList;

import java.util.Scanner;

public class SumOfNeighbors {

    public static void main(String[] args) {
        
        //Variáveis
        Scanner scanner = new Scanner(System.in);
        List<String[]> lines = new ArrayList<String[]>();
        int[][] matrix;
        int rows = 0;
        int columns = 0;

        //Lê todas as linhas e as armazena em uma Lista
        while (scanner.hasNext()) {
            
            String s = scanner.nextLine();
            if (s.equals("end")) {
                break;
            }

            String[] tokens = s.split(" ");
            lines.add(tokens);
        }

        //Pega a quantidade de linhas e colunas
        rows = lines.size();
        columns = lines.get(0).length;
        matrix = new int[rows][columns];

        //Armazena os dados na matriz
        for (int i = 0; i < rows; i++) {
            String[] line = lines.get(i);
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }

        //Calcula o resultado da soma
        int[][] sumMatrix = sumNeighbors(matrix, rows, columns);

        //Imprime a soma
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(sumMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] sumNeighbors(int[][] matrix, int rows, int columns) {
        int[][] sumMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int i0 = i - 1 < 0 ? rows - 1 : i - 1;
                int j0 = j;
                int a = matrix[i0][j0];

                int i1 = i + 1 > rows - 1 ? 0 : i + 1;
                int j1 = j;
                int b = matrix[i1][j1];

                int i2 = i;
                int j2 = j - 1 < 0 ? columns - 1 : j - 1;
                int c = matrix[i2][j2];

                int i3 = i;
                int j3 = j + 1 > columns - 1 ? 0 : j + 1;
                int d = matrix[i3][j3];

                sumMatrix[i][j] = a + b + c + d;
            }
        }

        return sumMatrix;
    }
}