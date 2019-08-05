package johnny.java.concurrency.readfiles;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

public class CallableTask implements Callable<String> {
    private String filename;

    public CallableTask(String filename) {
        this.filename = filename;
        System.out.println("Create Callable task to get content from " + filename);
    }

    public String getFileName() {
        return filename;
    }

    public String call() {
        String content = "";
        try {
            String currentDir = System.getProperty("user.dir");
            Path path = Paths.get(currentDir, "java-concurrency-readfiles", "files", filename);
            File file = path.toFile();

            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;
            while ((st = br.readLine()) != null) {
                //System.out.println("Read content from file : " + path + " at " + LocalDateTime.now().toString());
                //System.out.println("File " + filename + ": " + st);
                content += st;
            }

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            return content;
        }
    }
}
