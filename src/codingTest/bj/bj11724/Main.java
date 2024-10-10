package codingTest.bj.bj11724;

import java.io.*;
import java.util.*;

public class Main {

    static int arr[][];
    static boolean node[];
    static int N, count;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        node = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 무방향 그래프
            arr[a][b] = arr[b][a] = 1;
        }

        count = 0;

        for (int i = 1; i <= N; i++) {
            if (!node[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    static void dfs(int value) {

        if (node[value]) {
            return;
        }

        node[value] = true;
        for (int i = 1; i <= N; i++) {
            if (arr[value][i] == 1) {
                dfs(i);
            }
        }
    }


}
