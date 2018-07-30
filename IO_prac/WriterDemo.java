package IO_prac;

import java.io.*;
import java.util.Scanner;

public class WriterDemo {
    public static void main(String[] args) throws IOException {
        Writer writer = new FileWriter(new File("d:\\test.txt"));

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        writer.write(str);
        //char[] chars = str.toCharArray();
        //writer.write(chars);

        writer.close();
    }
}
