package inflearn.session02.ct08;

import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String answer = "NO";
        String str = br.readLine();
        str = str.toUpperCase().replaceAll("[^A-Z]", "");

        String temp = new StringBuilder(str).reverse().toString();

        if (str.equals(temp)) {
            answer = "YES";
        }

        System.out.println(answer);

    }
}
