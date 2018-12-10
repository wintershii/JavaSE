package para;

public class paraTest02 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        change(array);
        for (int temp : array){
            System.out.print(temp + " ");
        }
    }

    public static void change(int[] array){
        array = new int[]{6, 7, 8, 9, 0};
    }
}
