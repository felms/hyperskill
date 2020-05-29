import java.util.Arrays;

import java.util.Map;
import java.util.TreeMap;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s+");

        Map<String, Integer> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        Arrays.stream(words).forEach(s -> {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        });

        map.forEach((key, value) -> System.out.println(key + " " + value));
    }
}