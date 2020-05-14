import java.util.Scanner;

public class MaximumElement {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int max = Integer.MIN_VALUE;
        int iMax = -1;
        int jMax = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int number = scanner.nextInt();

                if (number > max) {
                    max = number;
                    iMax = i;
                    jMax = j;
                }
            }
        }

        System.out.println(iMax + " " + jMax);
    }
}