package para;

public class ArrayParaTest {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        change(array);
        System.out.println(array[0]);
    }

    public static void change(int[] array){
        array[0] = 0;
    }
}
