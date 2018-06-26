package fanxing;

public class ArrayClass<T> {
    private T[] array;

    public void setT(T[] array) {
        this.array = array;
    }
    public T[] getT(){
        return array;
    }
    public static void main(String[] args){
        ArrayClass<String> a = new ArrayClass<String >();
        String[] array = {"成员1","成员2","成员3","成员4","成员5"};
        a.setT(array);
        for(int i = 0; i < a.getT().length; i++){
            System.out.println(a.getT()[i]);
        }
    }
}
