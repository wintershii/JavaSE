package reflect.com;

import java.lang.reflect.Constructor;

public class Main_01 {
    public static void main(String[] args){
        Example_01 example= new Example_01("10","20","30");
        Class<?extends Example_01> exampleC = example.getClass();
        //获得所有构造方法
        Constructor[] declaredConstructors = exampleC.getDeclaredConstructors();
        for(int i = 0; i < declaredConstructors.length; i++){           //遍历构造方法
            Constructor<?>constructor = declaredConstructors[i];
            System.out.println("查看是否允许带有可变数量的参数："+constructor.isVarArgs());
            System.out.println("该构造方法的入口参数类型依次为：");
            Class[] parameterTypes = constructor.getParameterTypes();   //获取所有参数类型
            for(int j = 0; j < parameterTypes.length; j++){
                System.out.println(" "+parameterTypes[j]);
            }
            System.out.println("该构造方法可能抛出的异常类型为：");
            //获得所有可能抛出的异常信息类型
            Class[] exceptionTypes = constructor.getExceptionTypes();
            for(int j = 0; j < exceptionTypes.length; j++){
                System.out.println(" "+exceptionTypes[j]);
            }

            Example_01 example2 = null;
            while(example2 == null){
                try{
                    if(i == 2)//通过执行默认没有参数的构造方法创建对象
                        example2 = (Example_01)constructor.newInstance();
                    else if(i == 1)
                        //通过执行具有两个参数的构造方法创建对象
                        example2 = (Example_01)constructor.newInstance("7",5);
                    else{//通过执行具有可变数量参数的构造方法创建对象
                        Object[] parameters = new Object[]{new String[]{"100","200","300"}};
                        example2 = (Example_01)constructor.newInstance(parameters);
                    }
                }catch(Exception e){
                    System.out.println("在创建对象时抛出异常，下面执行setAccessible方法");
                    constructor.setAccessible(true);//设置为允许访问
                }
            }
            if(example2 != null){
                example2.print();
                System.out.println();
            }
        }
    }
}
