package inflearn.session02.ct03;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String result = "";

        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            if (word.length() > result.length()) {
                result = word;
            }
        }

        System.out.println(result);


    }
}
