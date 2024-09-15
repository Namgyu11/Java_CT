package inflearn.session02.ct01;

import java.util.*;
import java.io.*;

/**
 * 1. 문자 찾기
 */

/**
 * 풀이: String 내장 함수 사용해서 입력 받은 문자열에 포함된 문자열 갯수 세기
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().toLowerCase();
        char c = br.readLine().toLowerCase().charAt(0);

        long cnt = (int) str.chars()
                .filter(ch -> ch == c)
                .count();


        System.out.println(cnt);

    }

}
