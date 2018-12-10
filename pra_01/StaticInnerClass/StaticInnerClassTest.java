package cn.pra_01.StaticInnerClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StaticInnerClassTest {
    public static void main(String[] args) {
           double[] d = new double[20];
           for (int i = 0; i < d.length; i++){
               d[i] = 100*Math.random();
           }
           ArrayAlg.Pair p = ArrayAlg.minmax(d);
        System.out.println("min=" + p.getFirst());
        System.out.println("max=" + p.getSencond());
    }
}

class ArrayAlg{
    /**
     * A pire of floating-point numbers
     */
    public static class Pair{
        private double first;
        private double sencond;

        public Pair(double first, double sencond) {
            this.first = first;
            this.sencond = sencond;
        }

        public double getFirst() {
            return first;
        }

        public double getSencond() {
            return sencond;
        }
    }
    /**
     *  Computes both the minimum an the maximum of an array
     * @param values an array of floating-point numbers
     * @return a pair whose first element is the minimum and whose second element
     * is the maximum
     */

    public static Pair minmax(double... values){
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (double v : values){
            if (min > v) min = v;
            if (max < v) max = v;
        }
        return new Pair(min,max);
    }
}



