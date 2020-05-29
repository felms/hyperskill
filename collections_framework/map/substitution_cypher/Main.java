import java.util.Map;
import java.util.HashMap;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String originalAlphabet = scanner.nextLine();
        String resultingAlphabet = scanner.nextLine();

        Map<Character, Character> encodingMap = new HashMap<>();
        Map<Character, Character> decodingMap = new HashMap<>();

        for (int i = 0; i < originalAlphabet.length(); i++) {
            encodingMap.put(originalAlphabet.charAt(i), resultingAlphabet.charAt(i));
            decodingMap.put(resultingAlphabet.charAt(i), originalAlphabet.charAt(i));
        }

        String toEncode = scanner.nextLine();
        String encoded = scanner.nextLine();

        StringBuilder sb = new StringBuilder();

        for (char c : toEncode.toCharArray()) {
            sb.append(encodingMap.get(c));
        }
        System.out.println(sb.toString());

        sb = new StringBuilder();
        for (char c : encoded.toCharArray()) {
            sb.append(decodingMap.get(c));
        }
        System.out.println(sb.toString());
    }
}