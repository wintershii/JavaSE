package file.com;

import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args){
        File file = new File("D:\\word.txt");
        if(file.exists()){
            file.delete();
            System.out.println("该文件已删除");
        }else{
            try {
                file.createNewFile();
                System.out.println("文件已创建");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("执行结束");
            }
        }

    }
}
