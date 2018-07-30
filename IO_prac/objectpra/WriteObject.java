package IO_prac.objectpra;

import java.io.*;

public class WriteObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(
                new File("d:\\test.txt"))));

        oos.writeObject(new Person("shi",13,"A"));
        oos.writeObject(new Person("zhang",15,"B"));
        oos.writeObject(new Person("hao",18,"C"));

        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(
                new FileInputStream(new File("d:\\test.txt"))));
        Person p1 = (Person) ois.readObject();
        Person p2 = (Person) ois.readObject();
        Person p3 = (Person) ois.readObject();
        ois.close();
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
