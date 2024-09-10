package ktb_ct.week05.ct01;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] correctOrder = br.readLine().split(" ");
        String[] studentOrder = br.readLine().split(" ");

        Map<String, Integer> correctMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            correctMap.put(correctOrder[i], i);
        }

        int correctPairs = 0;

        // 올바른 순서로 적혀 있는 쌍의 개수
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (correctMap.get(studentOrder[i]) < correctMap.get(studentOrder[j])) {
                    correctPairs++;
                }
            }
        }

        int totalPairs = N * (N - 1) / 2;

        System.out.println(correctPairs + "/" + totalPairs);

    }

}
