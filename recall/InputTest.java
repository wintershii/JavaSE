package recall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputTest {
    public static void main(String[] args) throws IOException {
        String str = scan();
        System.out.println(str);
    }

    public static String scan() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        str = br.readLine();
        return str;
    }

}

