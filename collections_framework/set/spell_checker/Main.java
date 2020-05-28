import java.util.Arrays;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Set<String> knownWords = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        Set<String> text = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        
        int d = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < d; i++) {
            knownWords.add(scanner.nextLine().trim());
        }
        
        int l = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < l; i++) {
            text.addAll(Arrays.asList(scanner.nextLine().split("\\s+")));
        }

        text.removeAll(knownWords);

        for (String s : text) {
            System.out.println(s);
        }
    }
}