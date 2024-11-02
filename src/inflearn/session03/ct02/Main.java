package inflearn.session03.ct02;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int prev = Integer.parseInt(st.nextToken());
        int count = 1;

        while (st.hasMoreTokens()){
            int current = Integer.parseInt(st.nextToken());
            if(prev < current){
                count++;
                prev = current;
            }
        }

        System.out.println(count);
    }
}
