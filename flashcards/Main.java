import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        Flashcards flashcards = new Flashcards();

        String option = "";

        while (!"exit".equals(option)) {

            System.out.println("Input the action (add, remove, import, export, ask, exit):");
            option = br.readLine().trim();

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
                    System.out.println("Bye bye!");
            }
        }

    }
}
