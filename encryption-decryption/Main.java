public class Main {
    public static void main(String[] args) {
        
        String message = "we found a treasure!";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder encryptedMessage = new StringBuilder();

        for(char c : message.toCharArray()) {
            int pos = alphabet.indexOf(c);
            char d;
            if(pos >= 0) {
                int newPos = 25 - pos;
                d = alphabet.charAt(newPos);
            } else {
                d = c;
            }
            
            encryptedMessage.append(d);
        }
        
        System.out.println(encryptedMessage.toString());
    }
}