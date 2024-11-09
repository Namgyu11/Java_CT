package inflearn.session03.ct03;

import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] aMoves = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] bMoves = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        IntStream.range(0, N).forEach(i ->{
            int a = aMoves[i];
            int b = bMoves[i];

            System.out.println(
                    (a == b) ? "D" :
                            ((a == 1 && b == 3) || (a == 2 && b == 1) || (a == 3 && b == 2)) ? "A" : "B"
            );
        });

    }
}
