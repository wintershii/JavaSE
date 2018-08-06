package string;

public class StringBuilderTest {
    public static void main(String[] args) {
//        String str = "0";
//        for (int i = 1; i < 10; i++){
//            str += i;
//        }
//        System.out.println(str);

        StringBuilder sb = new StringBuilder("0");
        for (int i = 1; i < 10; i++){
            sb.append(i);
        }
        System.out.println(sb.toString());
    }
}
