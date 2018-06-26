package fanxing;

public class OverClass<T> {
    private T over;
    public T getOver(){
        return over;
    }
    public void setOver(T over){
        this.over = over;
    }
    public static void main(String[] args){
        //实例化一个Boolean型的对象
        OverClass<Boolean> over1 = new OverClass<Boolean>();
        //实例化一个Float型的对象
        OverClass<Float> over2 = new OverClass<Float>();
        over1.setOver(true);
        over2.setOver(12.3f);
        Boolean b = over1.getOver();
        Float f = over2.getOver();
        System.out.println(b);
        System.out.println(f);
    }
}
