package recall;

/**
 * 局部内部类的用法
 */
public class OutClass {
    private int a;
    public void test(int b){
        class Inner{
            public void change(){
                a = 7;
     //           b = 5;    //局部内部类只能访问声明为final的局部变量
                System.out.println(b);
            }
        }
        Inner i = new Inner();  //只在该方法内可见
        i.change();
    }

    public static void main(String[] args) {
        OutClass oc = new OutClass();
        oc.test(7);
        System.out.println(oc.a);
    }
}
