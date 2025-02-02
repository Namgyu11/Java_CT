package codingTest.bj.bj15686;

// 백준 15686, 치킨 배달
// 2025.02.02
import java.io.*;
import java.util.*;

class Pair {
    public int y, x;

    public Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int n;
    static int m;
    static int minSumDist = Integer.MAX_VALUE;

    static List<Pair> homeList = new ArrayList<>();
    static List<Pair> chickenList = new ArrayList<>();
    static boolean[] selected;
    static final int EMPTY = 0, HOME = 1, CHICKEN = 2;

    static void backtrack(int chickenIdx, int selectCnt) {
        if (selectCnt == m) {
            int sumDist = 0;

            for (Pair home : homeList) {
                int minDist = Integer.MAX_VALUE;

                for (int i = 0; i < chickenList.size(); i++) {
                    if (selected[i]) {
                        minDist = Math.min(minDist, calcDist(home, chickenList.get(i)));
                    }
                }

                sumDist += minDist;
            }

            minSumDist = Math.min(minSumDist, sumDist);
            return;
        }

        for (int i = chickenIdx; i < chickenList.size(); i++) {
            selected[i] = true;
            backtrack(i + 1, selectCnt + 1);

            selected[i] = false;
        }
    }

    static int calcDist(Pair home, Pair chicken) {
        return Math.abs(home.y - chicken.y) + Math.abs(home.x - chicken.x);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == HOME) {
                    homeList.add(new Pair(i, j));
                } else if (input == CHICKEN) {
                    chickenList.add(new Pair(i, j));
                }
            }
        }

        selected = new boolean[chickenList.size()];
        backtrack(0, 0);

        System.out.println(minSumDist);
    }
}