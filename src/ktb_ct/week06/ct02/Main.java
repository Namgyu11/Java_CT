package ktb_ct.week06.ct02;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            List<int[]> edges = new ArrayList<>();

            for(int j = 0; j < m; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                edges.add(new int[]{a,b});
            }

            Collections.sort(edges, Comparator.comparingInt(edge -> edge[0]));

            int[] parent = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                parent[j] = j;
            }

            int minFlights = 0;
            for (int[] edge : edges) {
                if (union(edge[0], edge[1], parent)) {
                    minFlights++;
                }
            }

            sb.append(minFlights).append("\n");
        }

        System.out.print(sb.toString());

    }

    private static int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    private static boolean union(int x, int y, int[] parent) {
        int rootX = find(x, parent);
        int rootY = find(y, parent);
        if (rootX != rootY) {
            parent[rootY] = rootX;
            return true;
        }
        return false;
    }
}
