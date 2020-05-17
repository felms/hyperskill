public class Main {
    public static void main(String[] args) {
        
        String mode = "enc";
        int key = 0;
        String data = "";

        for (int i = 0; i <= args.length - 2; i += 2) {
            
            if ("-mode".equals(args[i])) {
                mode = args[i + 1];
            } else if ("-key".equals(args[i])) {
                key = Integer.parseInt(args[i + 1]);
            } else if ("-data".equals(args[i])) {
                data = args[i + 1];
            }
        }

        String message = "";       
        
        if ("enc".equals(mode)) {
            message = encrypt(data, key);
        } else if ("dec".equals(mode)) {
            message = decrypt(data, key);
        }
        
        System.out.println(message);
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