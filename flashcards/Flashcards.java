import java.nio.file.Files;
import java.nio.file.Paths;

import java.io.*;
import java.util.*;

public class Flashcards {

    private Map<String, String> cardDef;
    private Map<String, String> defCard;
    private BufferedReader br;
    private Random random;
    private PrintWriter pw;

    public Flashcards() {
        this.cardDef = new TreeMap<>();
        this.defCard = new TreeMap<>();
        this.br  = new BufferedReader(new InputStreamReader(System.in));
        random = new Random();
    }

    public void addCard() {

        try {

            System.out.println("The card:");
            String card = br.readLine().trim();
            if (cardDef.containsKey(card)) {
                System.out.printf("The card \"%s\" already exists.\n", card);
                return;
            }

            System.out.println("The definition of the card:");
            String definition = br.readLine().trim();
            if (defCard.containsKey(definition)) {
                System.out.printf("The definition \"%s\" already exists.\n", definition);
                return;
            }

            cardDef.put(card, definition);
            defCard.put(definition, card);
            System.out.printf("The pair (\"%s\":\"%s\") has been added.\n", card, definition);

        } catch (IOException ioException) {
            System.err.println(ioException.getCause());
        }
    }

    public void removeCard() {

        try {

            System.out.println("The card:");
            String card = br.readLine().trim();
            if (cardDef.containsKey(card)) {
                String definition = cardDef.get(card);
                cardDef.remove(card);
                defCard.remove(definition);
                System.out.println("The card has been removed.");
            } else {
                System.out.printf("Can't remove \"%s\": there is no such card.\n", card);
            }

        } catch (IOException ioException) {
            System.err.println(ioException.getCause());
        }
    }

    public void importFromFile(){
        try {
            System.out.println("File name:");
            String fileName = br.readLine().trim(); // Get fileName

            //Read text from file and store on "text" (a StringBuilder so I can manipulate it)
            StringBuilder text = new StringBuilder(new String(Files.readAllBytes(Paths.get(fileName))).trim());

            //Delete the first and last char ('{' and '}')
            text = text.deleteCharAt(text.indexOf("{"));
            text = text.deleteCharAt(text.lastIndexOf("}"));

            //Make the entries and store them on new maps
            String[] pairs = text.toString().split(", ");
            TreeMap<String, String> cDef = new TreeMap<>();
            TreeMap<String, String> dCard = new TreeMap<>();

            for (String s : pairs) {
                String[] p = s.split("=");
                cDef.put(p[0], p[1]);
                dCard.put(p[1], p[0]);
            }

            //Update the instance maps with the items read from file
            cardDef.putAll(cDef);
            defCard = new TreeMap<>();
            for(String key : cardDef.keySet()) {
                defCard.put(cardDef.get(key), key);
            }

            System.out.printf("%d cards have been loaded.\n", pairs.length);
        } catch (IOException ioException) {
            System.out.println("Not Found");
        }
    }

    public void exportToFile() {
        try {
            System.out.println("File name:");
            String fileName = br.readLine().trim();
            pw = new PrintWriter(new File(fileName));
            pw.write(this.cardDef.toString());
            pw.flush();
            pw.close();
            System.out.printf("%d cards have been saved.\n", this.cardDef.size());
        } catch (IOException ioException) {
            System.err.println(ioException.getCause());
        }
    }

    public void ask() {

        try {

            System.out.println("How many times to ask?");
            int questions = Integer.parseInt(br.readLine().trim());
            List<String> cards = new ArrayList<>(cardDef.keySet());

            for (int i = 0; i < questions; i++) {
                int pos = random.nextInt(cardDef.size());
                String card = cards.get(pos);
                System.out.printf("Print the definition of \"%s\":\n", card);
                String answer = br.readLine().trim();
                String correctAnswer = cardDef.get(card);

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
        } catch (IOException ioException) {
            System.err.println(ioException.getCause());
        }
    }
}
