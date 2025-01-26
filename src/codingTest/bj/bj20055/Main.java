package codingTest.bj.bj20055;

import java.io.*;
import java.util.*;

// 백준 20055, 컨베이어 벨트 위의 로봇
// https://www.acmicpc.net/problem/20055
// 2025-01-26 실패
public class Main {

    static int n;
    static int k;
    static int[] a;
    static boolean[] existRobot;
    static int cnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        a = new int[2 * n + 1];
        existRobot = new boolean[n + 1];
        for (int i = 1; i <= 2 * n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        solution();

        System.out.println(cnt);
    }

    static void solution() {
        cnt = 1;

        while (true) {
            rotate();
            existRobot[n] = false;

            moveAllRobots();
            existRobot[n] = false;

            if (a[1] > 0) {
                existRobot[1] = true;
                a[1]--;
            }
            if (countZeroDurability() >= k) {
                break;
            }
            cnt++;
        }
    }

    static void rotate() {
        int tempA = a[2 * n];
        for (int i = 2 * n; i >= 2; i--) {
            a[i] = a[i - 1];
        }
        a[1] = tempA;

        for (int i = n; i >= 2; i--) {
            existRobot[i] = existRobot[i - 1];
        }
        existRobot[1] = false;
    }

    static void moveAllRobots() {
        for (int i = n - 1; i >= 1; i--) {
            if (existRobot[i]) {
                if (!existRobot[i + 1] && a[i + 1] >= 1) {
                    existRobot[i] = false;
                    existRobot[i + 1] = true;
                    a[i + 1]--;
                }
            }
        }
    }

    static int countZeroDurability() {
        int cnt = 0;

        for (int i = 1; i <= 2 * n; i++) {
            if (a[i] == 0) {
                cnt++;
            }
        }

        return cnt;
    }

}