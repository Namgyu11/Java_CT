package studyCT.CT10.ct01;

import java.io.*;
import java.util.*;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


            int n = Integer.parseInt(br.readLine());

            int[] sequence = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                  sequence[i] = Integer.parseInt(st.nextToken());
            }

            int maxCurrent = sequence[0];
            int maxGlobal = sequence[0];

            for (int i = 1; i < n; i++) {
                  maxCurrent = Math.max(sequence[i], maxCurrent + sequence[i]);
                  if (maxCurrent > maxGlobal) {
                        maxGlobal = maxCurrent;
                  }
            }

            System.out.println(maxGlobal);
      }
}
