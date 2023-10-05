package codingTest.bj.bj11047;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int cnt = 0;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = arr.length -1; i >=0 ; i--) {
            if(k < arr[i]){
                continue;
            }
            int q = k / arr[i];
            k %= arr[i];
            cnt += q;
        }
        System.out.println(cnt);
    }
}
