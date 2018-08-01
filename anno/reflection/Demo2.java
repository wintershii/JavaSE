package anno.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *  应用反射的API，获取类的信息(类的名字，属性，方法，构造器)
 */
public class Demo2 {
    public static void main(String[] args) {
        String path = "anno.reflection.User";
        try {
            Class<?> clazz = Class.forName(path);

            //类的名字
            System.out.println(clazz.getName()); //获得包名+类名
            System.out.println(clazz.getSimpleName()); //获得类名:User

            //获得属性信息
        //    Field[] fields = clazz.getFields(); //只能返回public属性
            Field[] fields = clazz.getDeclaredFields();//获得所有field
            try {
                Field f = clazz.getDeclaredField("name");
                System.out.println(fields.length);
                for (Field temp:fields){
                    System.out.println("属性" + temp);
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

            //获得方法信息
            Method[] method = clazz.getDeclaredMethods();
            Method m = clazz.getDeclaredMethod("getName",null);
            Method m2 = clazz.getDeclaredMethod("setName", String.class);
            for (Method temp:method){
                System.out.println("方法" + temp);
            }

            //获得构造器信息
            Constructor[] constructors = clazz.getDeclaredConstructors();

            System.out.println();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
