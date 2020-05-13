import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] movieTheater = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                movieTheater[i][j] = scanner.nextInt();
            }
        }

        int k = scanner.nextInt();
        scanner.close();
        
        int selectedRow = 0;

        for (int r = 0; r < n; r++) {
            int[] row = movieTheater[r];
            System.out.println(Arrays.toString(row));

            if (checkRow(row, k)) {
                selectedRow = r + 1;
                break;
            }
            
        }

        System.out.println(selectedRow);

    }

    static boolean checkRow(int[] row, int tickets) {

        int empty = 0;
        for (int seat : row) {
            if (seat == 0) {
                empty++;
            } else {
                empty = 0;
            }

            if (empty >= tickets) {
                return true;
            }
        }

        return false;
    }
}