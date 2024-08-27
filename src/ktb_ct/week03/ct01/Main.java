package ktb_ct.week03.ct01;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N + 1];
        int[] result = new int[M];

        backtrack(N, M, 0, visited, result);
    }

    public static void backtrack(int N, int M, int depth, boolean[] visited, int[] result) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                backtrack(N, M, depth + 1, visited, result);
                visited[i] = false;
            }
        }
    }
}