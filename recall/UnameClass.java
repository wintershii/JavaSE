package recall;

/**
 * 测试匿名内部类的使用
 */
interface Test{
    void change();
}

public class UnameClass {
    int a;
    public static void main(String[] args) {
        UnameClass uc = new UnameClass();
        uc.test();
    }

    public void test(){
        Test t = new Test(){        //可以用lambda表达式替代
            public void change(){
                System.out.println("111");
                a = 5;
            }
        };
        t.change();
        System.out.println(a);
    }
}
