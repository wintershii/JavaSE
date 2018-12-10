package cn.pra_01.lambda;

import java.util.Arrays;

/**
 * This program demonstrate the use of lambda expressions
 *
 */
public class LambdaTest {
    public static void main(String[] args) {
        String[] person = {"shi" , "zhang" , "zeng" , "hao" , "yi" , "a"};
        System.out.println(Arrays.toString(person));

        //字典顺序排序
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(person);

        System.out.println(Arrays.toString(person));

        //按字符串长度排序
        System.out.println("Sorted by length");
        Arrays.sort(person,(first,end) -> first.length() - end.length());
        System.out.println(Arrays.toString(person));

    }
}
