package codingTest.bj.bj15686;

// 백준 15686, 치킨 배달
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] city;
    static ArrayList<Point> houses = new ArrayList<>();
    static ArrayList<Point> chickens = new ArrayList<>();
    static int ans = Integer.MAX_VALUE;

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1) {
                    houses.add(new Point(i, j));
                } else if (city[i][j] == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }
        combination(0, 0, new int[M]);
        System.out.println(ans);
    }

    static void combination(int start, int cnt, int[] sel) {
        if (cnt == M) {
            int sum = calc(sel);
            ans = Math.min(ans, sum);
            return;
        }
        for (int i = start; i < chickens.size(); i++) {
            sel[cnt] = i;
            combination(i + 1, cnt + 1, sel);
        }
    }

    static int calc(int[] sel) {
        int sum = 0;
        for (Point house : houses) {
            int dist = Integer.MAX_VALUE;
            for (int idx : sel) {
                Point chicken = chickens.get(idx);
                dist = Math.min(dist, Math.abs(house.r - chicken.r) + Math.abs(house.c - chicken.c));
            }
            sum += dist;
        }
        return sum;
    }
}
