import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        int n = scanner.nextInt();
        double m = scanner.nextDouble();

        boolean found = true;
        int seed = k - 1;
        do {
            found = true;
            seed++;
            Random r = new Random(seed);
            for (int i = 0; i < n; i++) {
                double num = r.nextGaussian();
                if (num > m) {
                   found = false;
                }
            }
        } while (!found);

        System.out.println(seed);
    }
}