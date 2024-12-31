package inflearn.session03.ct06;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> results = IntStream.range(0, n)
                .mapToObj(i -> Integer.parseInt(st.nextToken()))
                .map(Main::reverseNum)
                .filter(Main::isPrimed)
                .toList();
        results.forEach(num -> System.out.print(num + " "));
    }

    private static int reverseNum(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }

    private static boolean isPrimed(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) { // 틀렸던 조건을 수정함
                return false;
            }
        }
        return true;
    }
}
