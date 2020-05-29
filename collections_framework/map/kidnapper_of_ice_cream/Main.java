import java.util.Scanner;

import java.util.Map;
import java.util.HashMap;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] availableWords = scanner.nextLine().split("\\s+");
        String[] note = scanner.nextLine().split("\\s+");

        Map<String, Integer> availableMap = new HashMap<>();
        for (String s : availableWords) {
            if (availableMap.containsKey(s)) {
                availableMap.put(s, availableMap.get(s) + 1);
            } else {
                availableMap.put(s, 1);
            }
        }

        Map<String, Integer> noteMap = new HashMap<>();
        for (String s : note) {
           if (noteMap.containsKey(s)) {
               noteMap.put(s, noteMap.get(s) + 1);
           } else {
               noteMap.put(s, 1);
           }
        }

        boolean getMoney = true;
        for (String s : noteMap.keySet()) {
            getMoney = getMoney && noteMap.get(s) <= availableMap.getOrDefault(s, 0);
        }

        System.out.println(getMoney ? "You get money" : "You are busted");
    }
}