package inflearn.session02.ct10;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        String str = input[0];
        char ch = input[1].charAt(0);

        int[] distances = new int[str.length()];
        int distance = 1000;

        for (int i = 0; i < str.length() ; i++) {
            if(str.charAt(i) == ch){
                distance = 0;
            }else {
                distance++;
            }
            distances[i] = distance;
        }

        distance = 1000;
        for(int i = str.length() -1; i >= 0; i--){
            if(str.charAt(i) == ch){
                distance = 0;
            }else {
                distance++;
            }
            distances[i] = Math.min(distances[i], distance);
        }

        for(int a : distances){
            System.out.print(a + " ");
        }
    }

}
