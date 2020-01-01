package johnny.java.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamExample {
    public static void main(String[] args) throws IOException {
        String path = "out/fileForStream.txt";
        File file = new File(path);
        FileOutputStream output = new FileOutputStream(file, false); // true: append, false: overwrite
        String content = "hello, file stream";
        System.out.println("Write to file: " + content);
        output.write(content.getBytes());
        output.flush();
        output.close();

        FileInputStream input = new FileInputStream(file);
        System.out.print("Read from file: ");
        int data = input.read();
        while (data != -1) {
            System.out.print((char)data);
            data = input.read();
        }
        System.out.println();
        input.close();
    }
}
