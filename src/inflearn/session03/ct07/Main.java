package inflearn.session03.ct07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = 0;
        int score = 0;

        for (int i = 0; i < n; i++) {
            int current = Integer.parseInt(st.nextToken());

            if (current == 1) {
                score++;
                total += score;
            } else {
                score = 0;
            }
        }

        System.out.println(total);
    }

}
