package reflect.com;

import java.lang.reflect.Method;

public class Example_03 {
    static void staticMethod(){
        System.out.println("执行staticMethod()方法");
    }
    public int publicMethod(int i){
        System.out.println("执行publicMethod()方法");
        return i*100;
    }
    protected int protectedMethod(String s, int i)throws NumberFormatException{
        System.out.println("执行protectedMethod()方法");
        return Integer.valueOf(s)+i;
    }
    private String privateMethod(String...strings){
        System.out.println("执行privateMethod()方法");
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i < strings.length; i++){
            stringBuffer.append(strings[i]);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args){
        Example_03 example = new Example_03();
        Class exampleC = example.getClass();
        Method[] declaredMethods = exampleC.getDeclaredMethods();
        for(int i =0; i < declaredMethods.length; i++){
            Method method = declaredMethods[i];
            System.out.println("名称为："+method.getName());
            System.out.println("是否带有可变数量的参数："+method.isVarArgs());
            System.out.println("入口参数类型依此为：");
            Class[] parameterTypes = method.getParameterTypes();
            for(int j = 0; j < parameterTypes.length; j++){
                System.out.println(" " +parameterTypes[j]);
            }
            System.out.println("返回值类型为："+method.getReturnType());
            System.out.println("可能抛出的异常类型有:");
            Class[] exceptionTypes = method.getExceptionTypes();
            for(int j = 0; j < exceptionTypes.length;j++){
                System.out.println(" "+exceptionTypes[j]);
            }
            boolean isTurn = true;
            while(isTurn){
                //如果该方法的访问权限为private则抛出异常
                try{
                    isTurn = false;
                    if("staticMethod".equals(method.getName()))
                        method.invoke(example);                 //执行没有入口参数的方法
                    else if("publicMethod".equals(method.getName()))
                        System.out.println("返回值为："+method.invoke(example,168));//执行方法
                    else if("protectedMethod".equals(method.getName()))
                        System.out.println("返回值为："+method.invoke(example,"7",5));//执行方法
                    else if("privateMethod".equals(method.getName())){
                        Object[] parameters = new Object[]{new String[]{"S","D","X"}};
                        System.out.println("返回值为："+method.invoke(example,parameters));
                    }

                }catch (Exception e){
                    System.out.println("在执行方法时抛出异常,"+"在下面执行setAccessible()方法");
                    method.setAccessible(true);
                    isTurn = true;
                }
            }
        }
    }
}
