package com.io.objectstream;

import java.io.*;

public class ObjectOutputDemo {
    public static void main(String[] args) {
        try {
            write("d:\\test.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //序列化
    public static void write(String path) throws IOException {
        Employee emp = new Employee("shidongxuan",3000);

        File file = new File(path);
        ObjectOutputStream dos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        dos.writeObject(emp);
        dos.close();
    }
}
