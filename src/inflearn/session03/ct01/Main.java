package inflearn.session03.ct01;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();

        int prev = Integer.parseInt(st.nextToken());
        result.append(prev).append(" ");

        while (st.hasMoreTokens()){

            int current = Integer.parseInt(st.nextToken());
            if(current > prev){
                result.append(current).append(" ");
            }
            prev = current;
        }

        System.out.println(result);

    }

}
