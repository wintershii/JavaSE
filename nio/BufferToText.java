package nio;

import java.nio.*;
import java.io.*;
import java.nio.channels.*;
import java.nio.charset.Charset;

public class BufferToText {
    public static void main(String[] args) throws IOException {
        FileChannel fc = new FileOutputStream(new File("d:\\test.txt")).getChannel();
        fc.write(ByteBuffer.wrap("这是shidongxuan".getBytes()));
        fc.close();
        fc = new FileInputStream(new File("d:\\test.txt")).getChannel();
        ByteBuffer buff = ByteBuffer.allocate(1024);
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());

        buff.rewind();
        //发现默认字符集
        String encoding = System.getProperty("file.encoding");
        //根据默认字符集解码
        System.out.println("Decoded using " + encoding + ": " + Charset.forName(encoding).decode(buff));

        // Encode with something that will print
        fc = new FileOutputStream(new File("d:\\test.txt")).getChannel();
        //utf-16be可以将文本写到文件中(在输入时进行编码)
        fc.write(ByteBuffer.wrap("这是shidongxuan".getBytes("utf-16be")));
        fc.close();
        fc = new FileInputStream(new File("d:\\test.txt")).getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());

        //Use a CharBuffer to write through
        fc = new FileOutputStream(new File("d:\\test.txt")).getChannel();
        buff = ByteBuffer.allocate(24);
        buff.asCharBuffer().put("师东璇");
        fc.write(buff);
        fc.close();
        //Read and display
        fc = new FileInputStream((new File("d:\\test.txt"))).getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());

    }
}
