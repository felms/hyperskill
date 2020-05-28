public class UnicodeAlgorithm implements Algorithm{

    public String encrypt(String message, int key) {

        StringBuilder encryptedMessage = new StringBuilder();

        for(char c : message.toCharArray()) {
            char d = (char) (c + key);
            encryptedMessage.append(d);
        }

        return encryptedMessage.toString();
    }

    public String decrypt(String message, int key) {

        StringBuilder decryptedMessage = new StringBuilder();

        for(char c : message.toCharArray()) {
            char d = (char) (c - key);
            decryptedMessage.append(d);
        }

        return decryptedMessage.toString();
    }
}
