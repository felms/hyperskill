import java.util.Scanner;

import java.util.Map;
import java.util.TreeMap;

import java.util.Set;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> word0 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        Map<String, Integer> word1 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        String[] w0 = scanner.nextLine().split("(?!^)");
        for (String s : w0) {
            if (word0.containsKey(s)) {
                word0.put(s, word0.get(s) + 1);
            } else {
                word0.put(s, 1);
            }
        }

        String[] w1 = scanner.nextLine().split("(?!^)");
        for (String s : w1) {
            if (word1.containsKey(s)) {
                word1.put(s, word1.get(s) + 1);
            } else {
                word1.put(s, 1);
            }
        }

        System.out.println(diff(word0, word1));
    }

    public static int diff(Map<String, Integer> word0, Map<String, Integer> word1) {

        Set<String> set = new TreeSet<>(word0.keySet());
        set.addAll(word1.keySet());

        int d = 0;
        for (String s : set) {
            if (word0.containsKey(s) && word1.containsKey(s)) {
                d += Math.abs(word0.get(s) - word1.get(s));
            } else if (word0.containsKey(s) && !word1.containsKey(s)) {
                d += word0.get(s);
            } else if (!word0.containsKey(s) && word1.containsKey(s)) {
                d += word1.get(s);
            }
        }
        return d;
    }
}