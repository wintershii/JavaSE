package IO_prac;

import java.io.*;

public class BufferedDemo {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(new File("d:\\test.txt")));

        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(new File("d:\\test_01.txt")));

        byte[] buf = new byte[64];
        int len = 0;
        while (-1 != (len = bis.read(buf))){
            bos.write(buf, 0, len);
            bos.flush();
        }
        bis.close();
        bos.close();
    }

}
