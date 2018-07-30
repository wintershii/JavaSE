package IO_prac;

import java.io.*;
import java.util.Scanner;

public class FileOutputDemo {
    public static void main(String[] args) throws IOException {
        OutputStream os = new FileOutputStream(new File("d:\\test.txt"));

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        byte[] flush = str.getBytes();

        os.write(flush);

        os.close();
    }
}
