package com.io.objectstream;

import java.io.*;

/**
 * 引用类型(对象) 保留数据+类型
 * 反序列化  输入流：ObjectInputStream
 * 序列化    输出流  ObjectOutputStream
 *
 * 注意：先序列化后反序列化； 反序列化顺序必须与序列化一致
 *        不是所有对象都可以序列化  必须实现 java.io.Serializable
 *        不是所有属性都需要序列化  不需要序列化的属性 要加  transient
 */

public class ObjectInputDemo {

    public static void main(String[] args) {
        try {
            read1("d:\\test.txt");
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    public static void read1(String path) throws IOException, ClassNotFoundException {

        File file = new File(path);
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
        Object obj = ois.readObject();
        if(obj instanceof Employee){
            Employee emp = (Employee)obj;
            System.out.println(emp.getName());
            System.out.println(emp.getSalary());
        }
        ois.close();

    }
}
