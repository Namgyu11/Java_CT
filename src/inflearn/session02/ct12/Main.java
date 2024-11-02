package inflearn.session02.ct12;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        StringBuilder result = new StringBuilder();

        for(int i = 0; i <n; i++){
            // 7 자리씩 끊기
            String pwd = str.substring(i * 7,(i + 1) * 7);

            String binary = pwd.replace('#' ,'1').replace('*', '0');

            int 아스키 = Integer.parseInt(binary, 2);

            result.append((char) 아스키);
        }

        System.out.println(result);
    }
}
