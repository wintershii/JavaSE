package para;

public class StringParaTest {
    public static void main(String[] args) {
        String str = "AAA";
        change(str);
        System.out.println(str);
    }

    public static void change(String str){
        str = "abc";
    }
}
