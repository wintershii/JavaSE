package anno.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Demo4 {
    public void test01(Map<String,User> map, List<User> list){
        System.out.println("Demo04.test01()");
    }

    public Map<Integer,User> test02(){
        System.out.println("Demo.test02()");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {

        //获得指定方法的参数泛型信息
        Method m = Demo4.class.getMethod("test01",Map.class,List.class);
        Type[] t = m.getGenericParameterTypes();//获得参数类型
        for (Type paramType: t){
            System.out.println("#" + paramType);
            if (paramType instanceof ParameterizedType){//判断是否存在泛型参数
                Type[] genericTypes = ((ParameterizedType) paramType).getActualTypeArguments();
                for (Type genericType:genericTypes){
                    System.out.println("泛型类型:" + genericType);
                }
            }
        }

        //获得指定方法返回值泛型信息
        Method m2 = Demo4.class.getMethod("test02",null);
        Type returnType = m2.getGenericReturnType();
        System.out.println(returnType);
        if (returnType instanceof ParameterizedType){
            Type[] genericTypes = ((ParameterizedType) returnType).getActualTypeArguments();
            for (Type genericType:genericTypes){
                System.out.println("返回值，泛型类型" + genericType);
            }
        }

    }
}
