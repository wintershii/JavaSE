package nio;

import java.io.*;
import java.nio.channels.FileChannel;

public class TransferTo {
    public static void main(String[] args) throws IOException {
        FileChannel in = new FileInputStream(new File("d:\\test.txt")).getChannel();
        FileChannel out = new FileOutputStream(new File("d:\\test_02.txt")).getChannel();

        //in.transferTo(0,in.size(),out);
        out.transferFrom(in,0,in.size());
    }
}
