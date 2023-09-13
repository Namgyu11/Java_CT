package codingTest.bj.bj10818;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();

        int[] num = new int[count];
        for (int i = 0; i < count; i++) {
            num[i] = sc.nextInt();
        }
        int max = Arrays.stream(num).max().getAsInt();
        int min = Arrays.stream(num).min().getAsInt();

        System.out.println(min + " " + max);
    }
}
