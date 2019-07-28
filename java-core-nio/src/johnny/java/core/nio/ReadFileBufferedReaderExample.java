package johnny.java.core.nio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileBufferedReaderExample {
    // Read file with classic IO APIs
    public static void main(String[] args) {
        BufferedReader br = null;
        String line = null;
        try {
            br = new BufferedReader(new FileReader("out/test.txt"));
            System.out.println("Reading file with BufferedReader...");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        }
        catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}
