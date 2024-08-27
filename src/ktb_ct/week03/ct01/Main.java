package ktb_ct.week03.ct01;


import java.io.*;
import java.util.*;

// 백트레킹
// 1. N과 M
public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N];
        int[] arr = new int[M];

        backtracking(N, M, 0, visited, arr);
    }

    private static void backtracking(int N, int M, int depth, boolean[] visited, int[] arr) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            for (int i = 1; i <= N; i++) {
                if (!visited[i - 1]) {
                    visited[i - 1] = true;
                    arr[depth] = i;
                    backtracking(N, M, depth + 1, visited, arr);
                    visited[i - 1] = false;
                }
            }

        }

    }

}
