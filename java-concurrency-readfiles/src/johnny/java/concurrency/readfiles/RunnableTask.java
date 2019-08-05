package johnny.java.concurrency.readfiles;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RunnableTask implements Runnable {
    private String filename;
    private String content;

    public RunnableTask(String filename) {
        this.filename = filename;
        this.content = "";
        System.out.println("Create Task to get content from " + filename);
    }

    public String getFileName() {
        return filename;
    }

    public void run() {
        try {
            String currentDir = System.getProperty("user.dir");
            Path path = Paths.get(currentDir, "java-concurrency-readfiles", "files", filename);
            File file = path.toFile();

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            while ((line = br.readLine()) != null) {
                content += line;
            }

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public String getContent() { return content; }
}
