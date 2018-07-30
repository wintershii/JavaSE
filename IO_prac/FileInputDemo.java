package IO_prac;


import java.io.*;

public class FileInputDemo {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream(new File("d:\\test.txt"));
        byte[] flush = new byte[1024];
        int len;
        while(-1 != (len = is.read(flush))){
            System.out.println(new String(flush));
        }
        is.close();
    }
}
