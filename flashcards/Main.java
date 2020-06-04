import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        String importFile = "";
        String exportFile = "";
        boolean loadCardsOnInit = false;
        boolean saveCardsOnExit = false;

        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if ("-import".equals(s)) {
                importFile = args[i + 1];
                loadCardsOnInit = true;
            } else if ("-export".equals(s)) {
                exportFile = args[i + 1];
                saveCardsOnExit = true;
            }
        }

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        Logger logger = new Logger();

        Flashcards flashcards = new Flashcards(logger);

        // Reads an initial cards set from an external file
        if (loadCardsOnInit) {
            flashcards.loadOnInit(importFile);
        }

        String option = "";

        while (!"exit".equals(option)) {

            String output = "Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):";
            logger.log(output);
            System.out.println(output);
            option = br.readLine().trim();
            logger.log(option);

            switch(option) {
                case "add":
                    flashcards.addCard();
                    break;

                case "remove":
                    flashcards.removeCard();
                    break;

                case "import":
                    flashcards.importFromFile();
                    break;

                case "export":
                    flashcards.exportToFile();
                    break;

                case "ask":
                    flashcards.ask();
                    break;

                case "exit":
                    output = "Bye bye!";
                    logger.log(output);
                    System.out.println(output);
                    break;

                case "log":
                    logger.saveToFile();
                    break;

                case "hardest card":
                    flashcards.hardestCard();
                    break;

                case "reset stats":
                    flashcards.resetStats();
                    break;

            }
        }

        // Writes all the cards that are in the program
        // memory to an external file
        if (saveCardsOnExit) {
            flashcards.saveOnExit(exportFile);
        }

    }
}
