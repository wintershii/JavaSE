package string;

public class Test {
    public static void main(String[] args) {
        String str = "helloworld";
        String str2 = "helloworld";

        System.out.println(str == str2);

        String str3 = new String("helloworld");
        String str4 = new String("helloworld");
        System.out.println(str3 == str4);

        System.out.println(str == str3);
    }
}
