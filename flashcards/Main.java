import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        Logger logger = new Logger();

        Flashcards flashcards = new Flashcards(logger);

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

    }
}
