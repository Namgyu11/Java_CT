package codingTest.bj.bj10807;

import java.util.Hashtable;
import java.util.Scanner;

// 백준 10807 - 개수 세기
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hashtable<Integer, Integer> hashtable = new Hashtable();
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();

            if(hashtable.containsKey(num)){
                hashtable.put(num,hashtable.get(num) + 1);
            }else {
                hashtable.put(num,1);
            }
        }
        int v = sc.nextInt();

        if(hashtable.get(v) == null){
            v = 0;
        }else {
            v = hashtable.get(v);
        }
        System.out.println(v);
    }
}
