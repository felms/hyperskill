import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        Map<Integer, Integer> seedMax = new HashMap<>();
        Random r;

        for (int i = a; i <= b; i++) {
            r = new Random(i);
            int max = 0;
            for (int j = 0; j < n; j++) {
                int number = r.nextInt(k);
                if (number > max) {
                    max = number;
                }
            }

            seedMax.put(i, max);
        }

        int min = Integer.MAX_VALUE;
        int seed = 0;
        for (int key : seedMax.keySet()) {
            int value = seedMax.get(key);
            if (value < min) {
                min = value;
                seed = key;
            } else if (value == min) {
                seed = Math.min(seed, key);
            }
        }

        System.out.printf("%d\n%d\n", seed, seedMax.get(seed));
    }
}