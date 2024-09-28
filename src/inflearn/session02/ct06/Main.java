package inflearn.session02.ct06;


import java.util.*;
import java.io.*;
// 중복문자제거
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Set<Character> charSet = new LinkedHashSet<>();
        for(char c : str.toCharArray()){
            charSet.add(c);
        }

        StringBuilder result = new StringBuilder();
        charSet.forEach(result::append);

        System.out.println(result);

    }
}
