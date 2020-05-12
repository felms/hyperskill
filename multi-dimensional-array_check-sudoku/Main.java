import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        //Inicialização de variáveis
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int size = n * n;
        
        int[][] sudoku = new int[size][size];
        
        boolean solved = true;
        
        //Lendo o sudoku
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sudoku[i][j] = scanner.nextInt();
            }
        }

        //Testando as linhas
        for (int i = 0; i < size; i++) {
            solved = solved && arraySolved(sudoku[i]);
        }
        
        //Testando as colunas
        for (int column = 0; column < size; column++) {
            int[] line = new int[size];
            for (int row = 0; row < size; row++) {
                line[row] = sudoku[row][column];
            }
            solved = solved && arraySolved(line);
        }

        //Testando os 'quadrados'
        for (int iStart = 0; iStart <= (size - n); iStart += n) {
            for (int jStart = 0; jStart <= (size - n); jStart += n) {
                int count = 0;
                int[] square = new int[size];
                for (int i = iStart; i < (iStart + n); i++) {
                    for (int j = jStart; j < (jStart + n); j++) {
                        square[count] = sudoku[i][j];
                        count++;
                    }
                }
                solved = solved && arraySolved(square);
            }
        }

        System.out.println(solved ? "YES" : "NO");
    }
    
    static boolean arraySolved(int[] arr) {
            
      int[] numbers = new int[arr.length + 10];
            
      for (int i = 0; i < numbers.length; i++) {
          numbers[i] = 0;    
      }
      
      for (int j = 0; j < arr.length; j++) {
          int n = arr[j];
          if (n > arr.length) {
            return false;
          }
          numbers[n]++;
      }
      
      for (int k = 0; k < numbers.length; k++) {
          if(numbers[k] > 1) {
              return false;
          }
      }
      
      return true;
    }
}
