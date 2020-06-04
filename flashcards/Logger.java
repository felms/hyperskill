import java.io.*;
import java.util.ArrayList;

public class Logger {

    private ArrayList<String> log;
    private BufferedReader br;
    private PrintWriter pw;

    public Logger() {
        this.log = new ArrayList<>();
    }

    public void log(String s){
        log.add(s);
        this.br  = new BufferedReader(new InputStreamReader(System.in));
    }

    public void saveToFile() {
        try {
            String output = "File name:";
            this.log(output);
            System.out.println(output);
            String fileName = br.readLine().trim();
            this.log(fileName);
            pw = new PrintWriter(new File(fileName));
            pw.write(this.toString());
            pw.flush();
            pw.close();
            output = "The log has been saved.";
            this.log(output);
            System.out.println(output);
        } catch (IOException ioException) {
            System.err.println(ioException.getCause());
        }
    }

    public String toString() {
        String r = "";
        for (String s : this.log) {
            r += s + "\n";
        }
        return r;
    }
}
