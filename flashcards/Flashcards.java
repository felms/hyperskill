import java.nio.file.Files;
import java.nio.file.Paths;

import java.io.*;
import java.util.*;

public class Flashcards {

    private Map<String, String> cardDef;
    private Map<String, String> defCard;
    private Map<String, Integer> cardError;
    private BufferedReader br;
    private Random random;
    private PrintWriter pw;
    private Logger logger;

    public Flashcards(Logger logger) {
        this.cardDef = new TreeMap<>();
        this.defCard = new TreeMap<>();
        this.cardError = new TreeMap<>();
        this.br  = new BufferedReader(new InputStreamReader(System.in));
        random = new Random();
        this.logger = logger;
    }

    public void addCard() {

        try {
            String output = "The card";
            logger.log(output);
            System.out.println(output);
            String card = br.readLine().trim();
            logger.log(card);
            if (cardDef.containsKey(card)) {
                output = String.format("The card \"%s\" already exists.", card);
                logger.log(output);
                System.out.println(output);
                return;
            }

            output = "The definition of the card:";
            logger.log(output);
            System.out.println(output);
            String definition = br.readLine().trim();
            logger.log(definition);
            if (defCard.containsKey(definition)) {
                output = String.format("The definition \"%s\" already exists.", definition);
                logger.log(output);
                System.out.println(output);
                return;
            }

            cardDef.put(card, definition);
            defCard.put(definition, card);
            cardError.put(card, 0);
            output = String.format("The pair (\"%s\":\"%s\") has been added.", card, definition);
            logger.log(output);
            System.out.println(output);

        } catch (IOException ioException) {
            System.err.println(ioException.getCause());
        }
    }

    public void removeCard() {

        try {

            String output = "The card";
            logger.log(output);
            System.out.println(output);
            String card = br.readLine().trim();
            logger.log(card);
            if (cardDef.containsKey(card)) {
                String definition = cardDef.get(card);
                cardDef.remove(card);
                defCard.remove(definition);
                cardError.remove(card);
                output = "The card has been removed.";
            } else {
                output = String.format("Can't remove \"%s\": there is no such card.", card);
            }
            logger.log(output);
            System.out.println(output);

        } catch (IOException ioException) {
            System.err.println(ioException.getCause());
        }
    }

    public void importFromFile(){
        try {

            String output = "File name:";
            logger.log(output);
            System.out.println(output);
            String fileName = br.readLine().trim(); // Get fileName
            logger.log(fileName);

            //Read text from file and store on "text" (a StringBuilder so I can manipulate it)
            StringBuilder text = new StringBuilder(new String(Files.readAllBytes(Paths.get(fileName))).trim());

            //Delete the first and last char ('{' and '}')
            text.deleteCharAt(text.indexOf("{"));
            text.deleteCharAt(text.lastIndexOf("}"));

            //Make the entries and store them on new maps
            String[] triples = text.toString().split(", ");
            TreeMap<String, String> cDef = new TreeMap<>();
            TreeMap<String, String> dCard = new TreeMap<>();
            TreeMap<String, Integer> cErr = new TreeMap<>();

            for (String s : triples) {
                String[] p = s.split("=");
                cDef.put(p[0], p[1]);
                dCard.put(p[1], p[0]);
                cErr.put(p[0], Integer.parseInt(p[2]));
            }

            //Update the instance maps with the items read from file
            cardDef.putAll(cDef);
            cardError.putAll(cErr);
            defCard = new TreeMap<>();
            for(String key : cardDef.keySet()) {
                defCard.put(cardDef.get(key), key);
            }
            output = String.format("%d cards have been loaded.", triples.length);
            logger.log(output);
            System.out.println(output);
        } catch (IOException ioException) {
            System.out.println("Not Found");
        }
    }

    public void loadOnInit(String fileName){

        try {

            String output = "";

            //Read text from file and store on "text" (a StringBuilder so I can manipulate it)
            StringBuilder text = new StringBuilder(new String(Files.readAllBytes(Paths.get(fileName))).trim());

            //Delete the first and last char ('{' and '}')
            text.deleteCharAt(text.indexOf("{"));
            text.deleteCharAt(text.lastIndexOf("}"));

            //Make the entries and store them on new maps
            String[] triples = text.toString().split(", ");
            TreeMap<String, String> cDef = new TreeMap<>();
            TreeMap<String, String> dCard = new TreeMap<>();
            TreeMap<String, Integer> cErr = new TreeMap<>();

            for (String s : triples) {
                String[] p = s.split("=");
                cDef.put(p[0], p[1]);
                dCard.put(p[1], p[0]);
                cErr.put(p[0], Integer.parseInt(p[2]));
            }

            //Update the instance maps with the items read from file
            cardDef.putAll(cDef);
            cardError.putAll(cErr);
            defCard = new TreeMap<>();
            for(String key : cardDef.keySet()) {
                defCard.put(cardDef.get(key), key);
            }
            output = String.format("%d cards have been loaded.", triples.length);
            logger.log(output);
            System.out.println(output);
        } catch (IOException ioException) {
            System.out.println("Not Found");
        }
    }

    public void exportToFile() {

        try {
            String output = "File name:";
            logger.log(output);
            System.out.println(output);
            String fileName = br.readLine().trim();
            logger.log(fileName);
            pw = new PrintWriter(new File(fileName));
            pw.write(this.toString());
            pw.flush();
            pw.close();
            output = String.format("%d cards have been saved.", this.cardDef.size());
            logger.log(output);
            System.out.println(output);
        } catch (IOException ioException) {
            System.err.println(ioException.getCause());
        }
    }

    public void saveOnExit(String fileName) {

        try {
            String output = "";
            pw = new PrintWriter(new File(fileName));
            pw.write(this.toString());
            pw.flush();
            pw.close();
            output = String.format("%d cards have been saved.", this.cardDef.size());
            logger.log(output);
            System.out.println(output);
        } catch (IOException ioException) {
            System.err.println(ioException.getCause());
        }
    }

    public void ask() {

        try {

            String output = "How many times to ask?";
            logger.log(output);
            System.out.println(output);
            String input = br.readLine().trim();
            logger.log(input);
            int questions = Integer.parseInt(input);
            List<String> cards = new ArrayList<>(cardDef.keySet());

            for (int i = 0; i < questions; i++) {
                int pos = random.nextInt(cardDef.size());
                String card = cards.get(pos);
                output = String.format("Print the definition of \"%s\":", card);
                logger.log(output);
                System.out.println(output);
                String answer = br.readLine().trim();
                String correctAnswer = cardDef.get(card);

                if (correctAnswer.equals(answer)) {
                    output = "Correct answer.";

                } else if (defCard.containsKey(answer)) {
                    output = String.format("Wrong answer. The correct one is \"%s\"," +
                                    " you've just written the definition of \"%s\".",
                            correctAnswer, defCard.get(answer));
                    cardError.put(card, cardError.get(card) + 1);

                } else {
                    output = String.format("Wrong answer. The correct one is \"%s\".", correctAnswer);
                    cardError.put(card, cardError.get(card) + 1);
                }

                logger.log(output);
                System.out.println(output);
            }
        } catch (IOException ioException) {
            System.err.println(ioException.getCause());
        }
    }

    public void hardestCard() {
        String output = "";
        ArrayList<String> hardest = new ArrayList<>();
        int maxErrors = 0;

        for (String s : this.cardDef.keySet()) {
            int errors = this.cardError.get(s);
            if (errors > maxErrors) {
                hardest.clear();
                hardest.add(s);
                maxErrors = errors;
            } else if (errors > 0 && errors == maxErrors) {
                hardest.add(s);
            }
        }

        if (hardest.size() == 0) {
            output = "There are no cards with errors.";

        } else if (hardest.size() == 1) {
            output = String.format("The hardest card is \"%s\". You have %d errors answering it.", hardest.get(0), maxErrors);
        } else if (hardest.size() > 1) {
            String names = "";
            for (int i = 0; i < hardest.size() - 1; i++) {
                String h = hardest.get(i);
                names += "\"" + h + "\", ";
            }
            names += "\"" + hardest.get(hardest.size() - 1) + "\"";

            output = String.format("The hardest cards are %s. You have %d errors answering them.", names, maxErrors);
        }
        logger.log(output);
        System.out.println(output);
    }

    public void resetStats() {

        for (String s : cardError.keySet()) {
            cardError.put(s, 0);
        }

        String output = "Card statistics has been reset.";
        logger.log(output);
        System.out.println(output);
    }

    public String toString() {

        StringBuilder r = new StringBuilder();
        r.append("{");
        for (String s : this.cardDef.keySet()) {
            r.append(String.format("%s=%s=%d, ", s, this.cardDef.get(s), this.cardError.get(s)));
        }

        if(this.cardDef.size() > 0) {
            r.deleteCharAt(r.lastIndexOf(" "));
            r.deleteCharAt(r.lastIndexOf(","));
        }
        r.append("}");
        return r.toString();
    }
}

