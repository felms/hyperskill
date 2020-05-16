import java.util.Scanner;

public class Main {

    static String consonants = "bcdfghjklmnpqrstvwxz";
    static String vowels = "aeiouy";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        
        int count = 0;

        while (isConsonantDiscordant(word)) {
            word = makeConsonantEuphonious(word);
            count++;
        }

        while (isVowelDiscordant(word)) {
            word = makeVowelEuphonious(word);
            count++;
        }

        System.out.println(count);
        
    }

    public static String makeConsonantEuphonious(String word) {

        StringBuilder sb = new StringBuilder(word);
        char[] w = word.toCharArray();
        
        for (int i = 0; i < w.length - 2; i++) {
            if (consonants.indexOf(w[i]) >= 0 &&
                consonants.indexOf(w[i + 1]) >= 0 &&
                consonants.indexOf(w[i + 2]) >= 0) {
                    sb.insert(i + 2, 'a');
                    return sb.toString();
                }
        }

        return null;
    }

    public static String makeVowelEuphonious(String word) {
        
        StringBuilder sb = new StringBuilder(word);
        char[] w = word.toCharArray();

        for (int i = 0; i < w.length - 1; i++) {
            if (vowels.indexOf(w[i]) >= 0 &&
                vowels.indexOf(w[i + 1]) >= 0 &&
                vowels.indexOf(w[i + 2]) >= 0) {
                    sb.insert(i + 2, 'b');
                    return sb.toString();
                }
        }

        return null;
    }

    public static boolean isConsonantDiscordant(String word) {

        int consonantsInARow = 0;

        for (char c : word.toCharArray()) {
            
            if (consonants.indexOf(c) >= 0) {
                consonantsInARow++;
            } else {
                consonantsInARow = 0;
            }

            if (consonantsInARow >= 3) {
                return true;
            }
        }

        return false;
    }

    public static boolean isVowelDiscordant(String word) {

        int vowelsInARow = 0;

        for (char c : word.toCharArray()) {
            
            if (vowels.indexOf(c) >= 0) {
                vowelsInARow++;
            } else {
                vowelsInARow = 0;
            }

            if (vowelsInARow >= 3) {
                return true;
            }
            
        }

        return false;
    }
}