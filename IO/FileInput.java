package file.com;

import java.io.*;
import java.util.Scanner;

public class FileInput {

    public static void main(String[] args){
        File file = new File("d:\\word.txt");
        try (
                FileOutputStream out = new FileOutputStream(file);
                Scanner scan = new Scanner(System.in)
                ){

            byte[] buffer = scan.next().getBytes();
            out.write(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try (
                FileInputStream in = new FileInputStream(file);
                ){
            byte[] buy2 = new byte[1024];
            int len = in.read(buy2);
            System.out.println("文件中的信息是：" + new String(buy2,0,len));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
