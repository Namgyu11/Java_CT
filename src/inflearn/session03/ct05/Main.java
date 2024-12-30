package inflearn.session03.ct05;

import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class Main {

    //다시 풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        //boolean[] isPrime = new boolean[n + 1];

//        Arrays.fill(isPrime, true);
//
//        isPrime[0] = false;
//        isPrime[1] = false;
//
//        for (int i = 0; i * i <= n; i++) {
//            if (isPrime[i]) {
//                for (int j = i * i; j <= n; j += i){
//                    isPrime[j] = false;
//                }
//            }
//        }
//
//        int count = 0;
//        for(int i = 2; i <= n; i++){
//            if(isPrime[i]){
//                count++;
//            }
//        }

        long count = IntStream.rangeClosed(2, n)
                .filter(Main::isPrime)
                .count();
        System.out.println(count);
    }


    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

