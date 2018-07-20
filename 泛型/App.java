package fanxing;


/**
 *获取值：
 * 1.强制类型转换
 * 2.类型检查：避免转换错误
 *
 */
public class App {
    public static void main(String[] args) {
        Object obj = 90;
        int score = (int)obj;   //Object-->Integer 自动拆箱
        System.out.println(score);

        //存入整数 自动装箱 int --> Integer --> Object
        Student stu = new Student(80,90);
        int javasescore = (Integer)stu.getJavase();
        String oraclScore = (String)stu.getOracle();
    }
}
