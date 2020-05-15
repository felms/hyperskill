import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        
        String[][] grid = new String[3][3];
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String input = scanner.nextLine();
        int pos = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
               grid[i][j] = String.valueOf(input.charAt(pos));
               pos++; 
            }
        }

        printGrid(grid);
        
    }

    static void printGrid(String[][] grid) {

        System.out.println("---------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println(" |");
        }

        System.out.println("---------");
    }
}