import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        String operation = scanner.nextLine();
        String operationEnc = "enc";
        String operationDec = "dec";
        String message = scanner.nextLine();
        int key = scanner.nextInt();


        String encryptedMessage = "";
        if (operation.equals(operationEnc)) {
            encryptedMessage = encrypt(message, key); 
        } else if (operation.equals(operationDec)) {
            encryptedMessage = decrypt(message, key);
        }
               
        
        System.out.println(encryptedMessage.toString());
    }


    public static String encrypt(String message, int key) {

        StringBuilder encryptedMessage = new StringBuilder();
        
        for(char c : message.toCharArray()) {
            char d = (char) (c + key);
            encryptedMessage.append(d);
        }

        return encryptedMessage.toString();
    }

    public static String decrypt(String message, int key) {

        StringBuilder decryptedMessage = new StringBuilder();
        
        for(char c : message.toCharArray()) {
            char d = (char) (c - key);
            decryptedMessage.append(d);
        }

        return decryptedMessage.toString();
    }
}