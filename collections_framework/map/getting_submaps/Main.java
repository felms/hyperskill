import java.util.Scanner;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TreeMap<Integer, String> map = new TreeMap<>();

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int numberOfPairs = scanner.nextInt();

        for (int i = 0; i < numberOfPairs; i++) {
            map.put(Integer.parseInt(scanner.next()), scanner.next());
        }

        map.subMap(a, true, b, true)
                .forEach((key, value) -> System.out.println(key + " " + value));
    }
}