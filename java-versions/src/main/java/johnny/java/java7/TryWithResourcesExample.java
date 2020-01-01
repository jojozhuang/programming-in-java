package johnny.java.java7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TryWithResourcesExample {
    public static void main(String args[]) {

        String currentDir = System.getProperty("user.dir");
        Path path = Paths.get(currentDir, "java-versions", "files", "jojozhuang.txt");
        File file = path.toFile();
        java6Resource(file);
        java7Resource(file);
        // custom closeable
        autoCloseableResource();
    }

    private static void java6Resource(File file) {
        // close resource in finally
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void java7Resource(File file) {
        // try with resources - automatic resource management
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // AutoCloseable
    private static void autoCloseableResource() {
        try (MyResource mr = new MyResource()) {
            System.out.println("MyResource created in try-with-resources");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Out of try-catch block.");
    }

    // Custom class implements AutoCloseable interface
    static class MyResource implements AutoCloseable{

        @Override
        public void close() throws Exception {
            System.out.println("Closing MyResource");
        }
    }

}
