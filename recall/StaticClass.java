package recall;

public class StaticClass {
    static class InnerClass{
        public static void test(){
            System.out.println("静态内部类测试");
        }
    }

    public static void main(String[] args) {
        InnerClass.test();
    }
}
