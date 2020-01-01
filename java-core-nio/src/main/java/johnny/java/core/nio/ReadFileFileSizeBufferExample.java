package johnny.java.core.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadFileFileSizeBufferExample {
    // Read a small file with buffer of file size
    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("out/test.txt","r");
            FileChannel channel = raf.getChannel();
            long fileSize = channel.size();
            ByteBuffer buffer = ByteBuffer.allocate((int) fileSize);
            channel.read(buffer);
            //buffer.rewind();
            buffer.flip();
            System.out.println("Reading file with Buffer of File Size...");
            for (int i = 0; i < fileSize; i++) {
                System.out.print((char) buffer.get());
            }
            buffer.clear();
            channel.close();
            raf.close();
        }
        catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}
