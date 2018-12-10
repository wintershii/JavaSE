package file.com;

import java.io.*;
import java.util.Scanner;

public class DateStream {
    public static void main(String[] args){
        try(
                FileOutputStream fs = new FileOutputStream("d:\\word.txt");
                DataOutputStream ds = new DataOutputStream(fs);
                ){
            Scanner scan = new Scanner(System.in);
            String word = scan.next();
            ds.writeUTF(word);
            //  ds.writeBytes(word);
            //  ds.writeChars(word);
            ds.close();
            FileInputStream fis = new FileInputStream("d:\\word.txt");
            DataInputStream dis = new DataInputStream(fis);
            System.out.println(dis.readUTF());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
