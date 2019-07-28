package johnny.java.core.nio;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedByteBufferExample {
    private static String fileName = "out/test.txt";
    private static String content;
    static {
        content = "iPad Pro(Latest Version)" + System.lineSeparator();
        content += "Model: 12.9-inch iPad Pro" + System.lineSeparator();
        content += "Color: Space Gray " + System.lineSeparator();
        content += "Storage: 256GB" + System.lineSeparator();
        content += "Connectivity: WiFI" + System.lineSeparator();
        content += "Price: $1149.00";
    }

    // Read a large file with MappedByteBuffer
    public static void main(String[] args) {
        try {
            prepare();
            System.out.println();
            readWithMappedByteBuffer(51);
            System.out.println();
            writeWithMappedByteBuffer(51, "[Applecare: 1year]" + System.lineSeparator());
            System.out.println();
            readWithMappedByteBuffer(0);
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private static void prepare() throws IOException {
        // Create file object
        File file = new File(fileName);

        //Delete the file
        file.delete();

        try (FileOutputStream output = new FileOutputStream(file, false)) {
            System.out.println("Preparing the file with content: ");
            System.out.println(content);
            output.write(content.getBytes());
        }
    }

    private static void readWithMappedByteBuffer(int pos) throws Exception {
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
            FileChannel channel = raf.getChannel();
            // specify the position where to start reading
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, pos, channel.size() - pos);
            buffer.load();
            System.out.println("Reading file with MappedByteBuffer at position: " + pos);
            for (int i = 0; i < buffer.limit(); i++) {
                System.out.print((char) buffer.get());
            }
        }
        System.out.println();
    }

    private static void writeWithMappedByteBuffer(int pos, String newline) throws Exception {
        try (RandomAccessFile raf = new RandomAccessFile(new File(fileName), "rw")) {
            // Get file channel in read-write mode
            FileChannel fileChannel = raf.getChannel();

            // Get direct byte buffer access using channel.map() operation
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, pos, newline.length());

            //Write the content using put methods
            System.out.println("Writing content to file with MappedByteBuffer at pos: " + pos);
            System.out.print(newline);
            buffer.put(newline.getBytes());
            System.out.println("Done!");
        }
    }
}
