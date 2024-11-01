package inflearn.session02.ct11;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringBuilder compressed = new StringBuilder();

        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == str.charAt(i - 1)){
                count++;
            }else {
                compressed.append(str.charAt(i -1));
                if(count > 1){
                    compressed.append(count);
                }
                count = 1;
            }
        }

        compressed.append(str.charAt(str.length()-1));

        if(count > 1){
            compressed.append(count);
        }

        System.out.println(compressed);
    }

}
