public class ShiftAlgorithm implements Algorithm{

    private String alphabetLCase = "abcdefghijklmnopqrstuvwxyz";
    private String alphabetUCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int alphabetSize = alphabetLCase.length();

    public String encrypt(String message, int key) {

        StringBuilder encryptedMessage = new StringBuilder();

        for(char c : message.toCharArray()) {

            String alphabet = "";
            if (Character.isUpperCase(c)) {
                alphabet = alphabetUCase;
            } else {
                alphabet = alphabetLCase;
            }

            int pos = alphabet.indexOf(c);

            char d;
            if(pos >= 0) {
                int newPos = (pos + key) % alphabetSize;
                d = alphabet.charAt(newPos);
            } else {
                d = c;
            }

            encryptedMessage.append(d);
        }

        return encryptedMessage.toString();
    }

    public String decrypt(String message, int key) {

        StringBuilder decryptedMessage = new StringBuilder();

        for(char c : message.toCharArray()) {

            String alphabet = "";
            if (Character.isUpperCase(c)) {
                alphabet = alphabetUCase;
            } else {
                alphabet = alphabetLCase;
            }

            int pos = alphabet.indexOf(c);

            char d;
            if(pos >= 0) {
                int newPos = (pos - key);
                if (newPos >= 0) {
                    newPos = newPos % alphabetSize;
                } else {
                    newPos = (newPos + alphabetSize) % alphabetSize;
                }
                d = alphabet.charAt(newPos);
            } else {
                d = c;
            }

            decryptedMessage.append(d);
        }

        return decryptedMessage.toString();
    }
}
