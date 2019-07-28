package johnny.java.core.io;

import java.io.*;
import java.util.Arrays;

public class FileDirectoryExample {
    private static String filename = "example-create-file.txt";
    public static void main(String[] args) throws IOException {
        fileWriteAndRead();
        fileRenameAndDelete();
        directory();
    }

    private static void fileWriteAndRead() throws IOException {
        // Create file instance
        File file = new File(filename);
        // Check if file Exists
        boolean fileExist = file.exists(); // false
        System.out.println("File exists:" + fileExist);
        // Create file on disk
        file.createNewFile();
        // creates a FileWriter Object
        Writer writer = new FileWriter(file);
        // Write content to file
        writer.write("hello, java io");
        writer.flush();
        writer.close();

        long length = file.length();
        System.out.println("File length:" + length);

        // Creates a FileReader Object
        FileReader reader = new FileReader(file);
        int data = reader.read();
        while (data != -1) {
            System.out.print((char)data);
            data = reader.read();
        }
        System.out.println();
        reader.close();
    }

    private static void fileRenameAndDelete() throws IOException {
        String newName = "renamed-file.txt";
        // rename file
        File oldFile = new File(filename);
        File newFile = new File(newName);
        oldFile.renameTo(newFile);
        System.out.println("Old file exists:" + oldFile.exists()); // false
        System.out.println("New file exists:" + newFile.exists()); // true

        // delete file
        newFile.delete();
        System.out.println("New file exists:" + newFile.exists()); // false
    }

    private static void directory() throws IOException {
        String directoryPath = "javaio/newdir";
        File dir1 = new File(directoryPath);
        // Clean directory if exists
        if (dir1.exists()) {
            deleteDirectory(dir1);
        }

        // Create a Directory if it does not exist
        //boolean dirCreated = dir1.mkdir(); // fails
        boolean dirCreated = dir1.mkdirs(); // return true
        System.out.println("Directory exists:" + dir1.exists()); // true

        boolean isDirectory = dir1.isDirectory(); // return true

        // Create multiple files
        for (int i = 1 ; i <= 5 ; i++){
            File file = new File(dir1, "name" + i + ".txt") ;
            file.createNewFile();
        }
        // List files in directory
        File dir2 = new File(directoryPath);
        String[] fileNames = dir2.list();
        Arrays.sort(fileNames);
        for (String filename : fileNames) {
            System.out.println(filename);
        }
        // Absolute file path
        File[] files = dir2.listFiles();
        Arrays.sort(files);
        for (File file : files) {
            System.out.println(file.getAbsoluteFile());
        }
    }

    private static boolean deleteDirectory(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                // recursively delete
                deleteDirectory(file);
            }
        }
        return dir.delete();
    }
}
