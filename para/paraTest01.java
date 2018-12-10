package para;

public class paraTest01 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        swap(a,b);
        System.out.println("最终 a = " + a);
        System.out.println("最终 b = " + b);
    }

    public static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
        System.out.println("方法中：a = " + a);
        System.out.println("方法中：b= " + b);
    }
}
