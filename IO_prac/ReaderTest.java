package IO_prac;

import java.io.*;

public class ReaderTest {
    public static void main(String[] args) throws IOException {
        Reader r = new FileReader(new File("d:\\test.txt"));
        char[] flush = new char[1024];
        int len;
        while (-1 != (len = r.read(flush))){
            System.out.println(new String(flush));
        }
        r.close();

    }
}
