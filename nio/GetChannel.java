package nio;

import java.io.*;
import java.io.IOException;
import java.nio.*;
import java.nio.channels.*;

public class GetChannel {
    public static void main(String[] args) throws IOException {
        // Write a file
        FileChannel fc = new FileOutputStream("d:\\test.txt").getChannel();
        fc.write(ByteBuffer.wrap("大家好我是shi".getBytes()));
        fc.close();
        //Add to the end of the file
        fc = new RandomAccessFile("d:test.txt","rw").getChannel();
        fc.position(fc.size());//Move to the end
        fc.write(ByteBuffer.wrap("来自shanxi".getBytes()));
        fc.close();
        //Read the file
        fc = new FileInputStream("d:\\test.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        fc.read(buffer);
        buffer.flip();
        while(buffer.hasRemaining()){
            System.out.println((char)buffer.get());
        }

    }
}
