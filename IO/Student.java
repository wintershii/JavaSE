package file.com;

import java.io.*;
import java.util.Scanner;

public class Student {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String[] content = new String[3];
        for(int i = 0; i < 3; i++ ){
            content[i] = scan.next();
        }
        File file = new File("d:\\word2.txt");
        try(
                FileWriter fw = new FileWriter(file);
                BufferedWriter bufw = new BufferedWriter(fw);

                ) {
            for(int k = 0; k < 3; k ++){
                bufw.write(content[k]);
                bufw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(
            FileReader fr = new FileReader(file);
            BufferedReader bufr = new BufferedReader(fr);
            )
        {
            String s = null;
            int i = 0;
            while((s = bufr.readLine() ) != null){
                i++;
                System.out.println("第" + i + "行 : " + s );
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
