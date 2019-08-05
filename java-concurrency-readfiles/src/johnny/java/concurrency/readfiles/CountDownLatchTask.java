package johnny.java.concurrency.readfiles;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTask extends Thread {
    private String filename;
    private String content;
    private CountDownLatch latch;

    public CountDownLatchTask(String filename, CountDownLatch latch) {
        this.filename = filename;
        this.content = "";
        this.latch = latch;
        System.out.println("Create Task to get content from " + filename);
    }

    @Override
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
            latch.countDown();

        } catch (FileNotFoundException nfe) {
            nfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public String getContent() { return content; }
}