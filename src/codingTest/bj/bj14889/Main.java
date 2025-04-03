package codingTest.bj.bj14889;

import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] S;
    static boolean[] selected;
    static int minDiff = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        S = new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        selected = new boolean[N];
        selected[0] = true;
        combination(1, 1);
        System.out.println(minDiff);
    }
    static void combination(int idx, int count) {
        if(count == N/2) {
            calculateDiff();
            return;
        }
        for(int i = idx; i < N; i++){
            selected[i] = true;
            combination(i+1, count+1);
            selected[i] = false;
        }
    }
    static void calculateDiff() {
        int startSum = 0;
        int linkSum = 0;
        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                if(selected[i] && selected[j]) {
                    startSum += S[i][j] + S[j][i];
                } else if(!selected[i] && !selected[j]) {
                    linkSum += S[i][j] + S[j][i];
                }
            }
        }
        int diff = Math.abs(startSum - linkSum);
        minDiff = Math.min(minDiff, diff);
    }
}
