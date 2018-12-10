package cn.pra_01.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class comparator_Demo {

    public static void main(String[] args) {
        String[] words = {"abc" , "d" , "efgh" , "sdsdsd"};

        Comparator<String> com = new lengthComparator();

        Arrays.sort(words,com);

        for (String str : words){
            System.out.println(str);
        }

    }
}

class lengthComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}
