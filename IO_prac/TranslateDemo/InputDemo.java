package IO_prac.TranslateDemo;

import java.io.*;

public class InputDemo {
    public static void main(String[] args) throws IOException {
        String file = "d:\\test.txt";

       OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(new File(file)),"utf-8");

        osw.write("这是要保存的字符");
        osw.close();

        InputStreamReader isr = new InputStreamReader(new FileInputStream(new File(file)),"utf-8");
        char[] buf = new char[1024];
        isr.read(buf);
        System.out.println(buf);
    }
}
