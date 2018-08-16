package recall;

/**
 * 最简单的内部类
 */
public class InnerClass {
    private int test = 0;

    public class Hello{
        static final int a = 5; //内部类中的静态域必须被final修饰
        public void change(){
            test = 2;

        }
    }


    public static void main(String[] args) {
        InnerClass ic = new InnerClass();
        ic.new Hello().change();
        System.out.println(ic.test);
    }
}
