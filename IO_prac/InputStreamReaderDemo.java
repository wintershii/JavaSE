package IO_prac;

import java.io.*;

public class InputStreamReaderDemo {
    public static void main(String[] args) throws IOException {
        //字节流-->字符流
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Writer writer = new FileWriter(new File("d:\\test.txt"));
        String line = null;

        while ((line = reader.readLine()) != null){
            if ("over".equals(line)){
                break;
            }
            writer.write(line);

        }
    }
}
