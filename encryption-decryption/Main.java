import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        int key = scanner.nextInt();

        String encryptedMessage = encrypt(message, key);        
        
        System.out.println(encryptedMessage.toString());
    }


    public static String encrypt(String message, int key) {

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int aSize = alphabet.length();
        StringBuilder encryptedMessage = new StringBuilder();
        
        for(char c : message.toCharArray()) {
            int pos = alphabet.indexOf(c);
            char d;
            if(pos >= 0) {
                int newPos = (pos + key) % aSize;
                d = alphabet.charAt(newPos);
            } else {
                d = c;
            }
            
            encryptedMessage.append(d);
        }

        return encryptedMessage.toString();
    }
}