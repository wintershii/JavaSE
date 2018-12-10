package anno;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用反射读取注解的信息  模拟处理注解信息的流程
 */
public class AnnoDemo {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("anno.MyStudent");
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation a: annotations){
                System.out.println(a);
            }
            MyTable mt = (MyTable) clazz.getAnnotation(MyTable.class);
            System.out.println(mt.value());

            //获得类的属性的注解
            Field f = clazz.getDeclaredField("name");
            MyField mf = f.getAnnotation(MyField.class);
            System.out.println(mf.columnName());

            //根据获得的表名，字段的信息，拼出DDL语句，然后使用JDBC执行这个SQL，在数据库中生成相关的表
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
