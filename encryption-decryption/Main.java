import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        String mode = "enc";
        int key = 0;
        String data = "";
        String in = "";
        String out = "";

        for (int i = 0; i <= args.length - 2; i += 2) {
            
            if ("-mode".equals(args[i])) {
                mode = args[i + 1];
            } else if ("-key".equals(args[i])) {

                try {
                    key = Integer.parseInt(args[i + 1]);
                } catch (NumberFormatException nfe) {
                    System.out.printf("Error: %s", nfe.toString());
                }

            } else if ("-data".equals(args[i])) {
                data = args[i + 1];
            } else if ("-in".equals(args[i])) {
                in = args[i + 1];
            } else if ("-out".equals(args[i])) {
                out = args[i + 1];
            }
        }

        String message = "";       
        
        if ("".equals(data) && !"".equals(in)) {

            //Lê texto de um arquivo
            try (Scanner scanner = new Scanner(new File(in))) {
                data = scanner.nextLine();
            } catch (FileNotFoundException fnfe) {
                System.out.printf("Error:%s", fnfe.toString());
            }

        }

        if ("enc".equals(mode)) {            
            message = encrypt(data, key);                        
        } else if ("dec".equals(mode)) {
           message = decrypt(data, key);
        }

        if (!"".equals(out)) {

            try (PrintWriter pw = new PrintWriter(new File(out))) {
                pw.write(message);
            } catch (FileNotFoundException fnfe) {
                System.out.printf("Error:%s", fnfe.toString());
            }

        } else {        
            System.out.println(message);
        }
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