package johnny.java.core.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadFileFixedSizeBufferExample {
    // Read a large file with fixed size buffer
    public static void main(String[] args) {
        try {
            int capacity = 32; // chunk size
            RandomAccessFile raf = new RandomAccessFile("out/test.txt", "r");
            FileChannel channel = raf.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(capacity);
            System.out.println("Reading file with Buffer of Fixed Size...");
            //int chunk = 1;
            while (channel.read(buffer) > 0) {
                //System.out.println("Chunk:" + chunk++);
                buffer.flip();
                for (int i = 0; i < buffer.limit(); i++) {
                    System.out.print((char) buffer.get());
                }
                buffer.clear(); // do something with the data and clear/compact it.
            }
            channel.close();
            raf.close();
        }
        catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}
