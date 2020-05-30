import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        Map<String, String> cardDef = new TreeMap<>();
        Map<String, String> defCard = new TreeMap<>();

        System.out.println("Input the number of cards:");
        int numberOfCards = Integer.parseInt(br.readLine());

        for (int i = 0; i < numberOfCards; i++) {
            System.out.printf("The card #%d:\n", i + 1);
            String card = br.readLine().trim();
            while (cardDef.containsKey(card)) {
                System.out.printf("The card \"%s\" already exists. Try again:\n", card);
                card = br.readLine().trim();
            }

            System.out.printf("The definition of the card #%d:\n", i + 1);
            String definition = br.readLine().trim();
            while (defCard.containsKey(definition)) {
                System.out.printf("The definition \"%s\" already exists. Try again:\n", definition);
                definition = br.readLine().trim();
            }

            cardDef.put(card, definition);
            defCard.put(definition, card);
        }

        for (String c : cardDef.keySet()) {
            System.out.printf("Print the definition of \"%s\":\n", c);
            String answer = br.readLine().trim();
            String correctAnswer = cardDef.get(c);

            if (correctAnswer.equals(answer)) {
                System.out.println("Correct answer.");
            } else if (defCard.containsKey(answer)) {
                System.out.printf("Wrong answer. The correct one is \"%s\"," +
                                    " you've just written the definition of \"%s\".\n",
                                    correctAnswer, defCard.get(answer));

            } else {
                System.out.printf("Wrong answer. The correct one is \"%s\".\n", correctAnswer);
            }
        }
    }
}
