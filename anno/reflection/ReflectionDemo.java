package anno.reflection;

/**
 *  测试java.lang.Class对象的获取方式
 */
public class ReflectionDemo {
    public static void main(String[] args) {
        String path = "anno.reflection.User";

        try {
            //反射机制核心
            Class<?> clazz = Class.forName(path);
            //对象用来表示或封装数据。一个类被加载后，JVM会创建一个对应该类的Class对象，类的整个结构信息
            //会放到对应的Class对象中
            //这个Class对象就像一面镜子，通过这面镜子可以看到对应类的全部信息，所以叫做反射
            System.out.println(clazz);
            //同样的类只会被加载一次  对象可以有多个，但是一个类只对应一个Class对象


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
