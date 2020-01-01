package johnny.java.concurrency.readfiles;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTask implements Runnable {
    private String filename;
    private String content;
    private final CyclicBarrier cyclicBarrier;

    public CyclicBarrierTask(String filename, CyclicBarrier cyclicBarrier) {
        this.filename = filename;
        this.content = "";
        this.cyclicBarrier = cyclicBarrier;
        System.out.println("Create Task to get content from " + filename);
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
            cyclicBarrier.await();
        } catch (FileNotFoundException nfe) {
            nfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public String getContent() { return content; }
}