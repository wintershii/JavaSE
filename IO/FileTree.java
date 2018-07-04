package file.com;

import java.io.File;
import java.util.Scanner;

public class FileTree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String f = scan.nextLine();
        File file = new File(f);
        printFile(file,0);
    }
    static void printFile(File file,int step){
        for(int i = 0; i < step; i++){
            System.out.print("-");
        }
        System.out.println(file.getName());
        if(file.isDirectory()){
            File[] files= file.listFiles();
            for(File temp : files){
                printFile(temp,step+1);
            }
        }
    }

}
