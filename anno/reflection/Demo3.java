package anno.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射API动态的操作：构造器，方法，属性
 */
public class Demo3 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        String path = "anno.reflection.User";
        try {
            Class<?> clazz = Class.forName(path);

            //动态调用构造方法，构造对象
            User u = (User) clazz.newInstance();//其实是调用了user的无参构造器
            //javabean必须有无参构造器
            System.out.println(u);

            Constructor<User> c = (Constructor<User>) clazz.getDeclaredConstructor(int.class,int.class,String.class);
            User u2 = c.newInstance(1001,18,"shidong");

            System.out.println(u2.getName());

            //通过反射API调用普通方法
            User u3 = (User) clazz.newInstance();

            Method method = clazz.getDeclaredMethod("setName", String.class);
            method.invoke(u3,"wtf");                //u3.setName("wtf");
            System.out.println(u3.getName());

            //通过反射API操作属性
            User u4 = (User) clazz.newInstance();
            Field f = clazz.getDeclaredField("name");
            f.setAccessible(true);  //这个属性不用做安全检查了
            f.set(u4,"zhang");      //无法访问私有属性，通过反射直接写属性
            System.out.println(u4.getName());   //通过反射直接读属性
            System.out.println(f.get(u4));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
