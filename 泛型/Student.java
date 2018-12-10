package fanxing;

/**
 * Object 可以接受任意类型,因为发生多态
 *
 */

public class Student  {
    private Object javase;
    private Object oracle;


    public Student(Object javase, Object oracle) {
        this.javase = javase;
        this.oracle = oracle;
    }

    public void setJavase(Object javase) {
        this.javase = javase;
    }

    public void setOracle(Object oracle) {
        this.oracle = oracle;
    }

    public Object getJavase() {
        return javase;
    }

    public Object getOracle() {
        return oracle;
    }
}
