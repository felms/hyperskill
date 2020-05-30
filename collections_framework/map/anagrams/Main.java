import java.util.*;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> word0 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        Map<String, Integer> word1 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        String w0 = scanner.nextLine();
        Arrays.stream(w0.split("(?!^)")).forEach(s -> {
            if (word0.containsKey(s)) {
                word0.put(s, word0.get(s) + 1);
            } else {
                word0.put(s, 1);
            }
        });

        String w1 = scanner.nextLine();
        Arrays.stream(w1.split("(?!^)")).forEach(s -> {
            if (word1.containsKey(s)) {
                word1.put(s, word1.get(s) + 1);
            } else {
                word1.put(s, 1);
            }
        });

        System.out.println(word0.equals(word1) ? "yes" : "no");
    }
}