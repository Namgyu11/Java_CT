package codingTest.bj.bj01158;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();

        int N = sc.nextInt();
        int M = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        while (list.size() >= 1){
            for (int i = 0; i < M -1 ; i++) {
                list.addLast(list.pollFirst());
            }
            if(list.size() == N){
                System.out.print("<"+list.pollFirst() + ", ");
            }else if(list.size() == 1){
                System.out.print(list.pollFirst() + ">");
            }else {
                System.out.print(list.pollFirst() + ", ");
            }

        }

    }
}
