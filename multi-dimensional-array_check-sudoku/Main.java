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

        System.out.println(Arrays.deepToString(sudoku));
        
        //Test all lines
        for (int i = 0; i < size; i++) {
            solved = solved && arraySolved(sudoku[i]);
            System.out.println(solved);
        }
        
        //Test all columns
        for (int column = 0; column < size; column++) {
            int[] line = new int[size];
            for(int row = 0; row < size; row++) {
                line[row] = sudoku[row][column];
            }
            solved = solved && arraySolved(line);
        }

        //Test all squares
                
        
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

      System.out.println(Arrays.toString(numbers));
      
      for (int k = 0; k < numbers.length; k++) {
          if(numbers[k] > 1) {
              return false;
          }
      }
      
      return true;
    }
}
