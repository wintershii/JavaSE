package file.com;

import java.io.File;

public class FileTest2 {
    public static void main(String[] args){
        File file = new File("d:\\word.txt");
        if(file.exists()){
            String name = file.getName();
            long length = file.length();
            boolean hidden = file.isHidden();
            System.out.println("文件名称：" + name);
            System.out.println("文件长度：" + length);
            System.out.println("是否被隐藏：" + hidden);
        }else {
            System.out.println("该文件不存在");
        }
    }
}
