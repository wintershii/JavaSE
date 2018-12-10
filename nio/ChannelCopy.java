package nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {
    public static void main(String[] args) throws IOException {
        FileChannel in = new FileInputStream(new File("d:\\test.txt")).getChannel();
        FileChannel out = new FileOutputStream(new File("d:\\test_02.txt")).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(12);
        while (in.read(buffer) != -1){
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }
    }
}
