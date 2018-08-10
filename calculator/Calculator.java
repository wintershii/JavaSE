package calculator;

import java.math.BigDecimal;
import java.util.*;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String middle = scan.nextLine();
        char[] mid = middle.toCharArray();
        List list = transferToBehind(mid);
        System.out.println(list);

        BigDecimal comeOut = calculator(list);
        System.out.println(comeOut);
    }

    public static BigDecimal calculator(List list){
        Deque<BigDecimal> deque = new ArrayDeque<>();

        Iterator it = list.iterator();
        while (it.hasNext()){
            Object o = it.next();
            if (o.getClass() == BigDecimal.class){
                deque.addFirst((BigDecimal)o);
            }else if (o.getClass() == Character.class){
                BigDecimal first = deque.removeFirst();
                BigDecimal second = deque.remove();
                BigDecimal out = null;
                if ((Character)o == '+'){
                    out = second.add(first);
                }else if ((Character)o == '-'){
                    out = second.subtract(first);
                }else if ((Character)o == '*'){
                    out = second.multiply(first);
                }else if ((Character)o == '/'){
                    out = second.divide(first);
                }
                deque.addFirst(out);
            }
        }
        BigDecimal comeOut = deque.removeFirst();
        return comeOut;
    }



    public static List transferToBehind(char[] mid){
        Deque<Character> deque = new ArrayDeque<>();
        List list = new ArrayList();

        int len = mid.length;
        int i,k=0;

        for (i = 0; i < len; i++){
            if ( (judgeSymbol(mid[i]) && ((i > 0 && mid[i-1] != ')') || i == 0) ) || mid[i] == ')'){
                if (mid[i] == '-' && (i == 0 || judgeSymbol(mid[i-1]) || judgeBrackets(mid[i-1]))){
                        continue;
                }
                String number = new String(mid).substring(k, i);
                    BigDecimal num = new BigDecimal(number);
                    list.add(num);
                    System.out.println(number);
                    if (judgeSymbol(mid[i]) )
                        k = i + 1;
                    else if (mid[i] == ')'){
                        k = i + 2;
                    }
            }



            if (judgeNumber(mid[i]) && lastNumber(mid,i)){
                String number = new String(mid).substring(i);
                System.out.println(number);
                list.add(new BigDecimal(number));
                break;
            }

            if (mid[i] == '('){
                k++;
            }

            if (judgeSymbol(mid[i]) || judgeBrackets(mid[i]) ){
                if (mid[i] == '*' || mid[i] == '/'){
                    deque.addFirst(mid[i]);
                }else if (mid[i] == '+' || mid[i] == '-'){
                    if (deque.isEmpty()){
                        deque.addFirst(mid[i]);
                    }else if (judgeSymbol(deque.peekFirst())){
                        while ( !deque.isEmpty() && deque.peekFirst() != '('){
                            list.add(deque.removeFirst());
                        }
                        deque.addFirst(mid[i]);
                    }else {
                        deque.addFirst(mid[i]);
                    }
                }else if (mid[i] == '('){
                    deque.addFirst(mid[i]);
                }else if (mid[i] == ')'){
                    while ( deque.peekFirst() != '('){
                        list.add(deque.removeFirst());
                    }
                    deque.removeFirst();
                }
            }else {
                continue;
            }
        }
        while ( !deque.isEmpty()){
            list.add(deque.removeFirst());
        }
        System.out.println(list);
        return list;
    }


    public static boolean judgeSymbol(char word){
        if (word == '+' || word == '-' || word == '*' || word == '/' ){
            return true;
        }
        return false;
    }
    public static boolean judgeBrackets(char word){
        if (word == '(' || word == ')'){
            return true;
        }
        return false;
    }

    public static boolean judgeNumber(char word){
        if (word >= '0' && word <= '9' || word == '.'){
            return true;
        }
        return false;
    }


    public static boolean lastNumber(char[] mid,int i){
        String str = new String(mid);
        String rest = str.substring(i+1);
        if (rest.contains("*") || rest.contains("/") || rest.contains("+") ||rest.contains("-") ||rest.contains("(")
                || rest.contains(")") ){
            return false;
        }
        return true;
    }

}
