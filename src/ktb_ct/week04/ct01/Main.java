package ktb_ct.week04.ct01;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] studentNumbers = new String[n];

        for (int i = 0; i < n; i++) {
            studentNumbers[i] = br.readLine();
        }

        int len = studentNumbers[0].length();
        for (int k = 1; k <= len; k++) {
            Set<String> uniqueNumbers = new HashSet<>();
            boolean allUnique = true;

            for (String number : studentNumbers) {
                String suffix = number.substring(len - k);
                if (uniqueNumbers.contains(suffix)) {
                    allUnique = false;
                    break;
                }
                uniqueNumbers.add(suffix);
            }

            if (allUnique) {
                System.out.println(k);
                break;
            }
        }
    }
}
