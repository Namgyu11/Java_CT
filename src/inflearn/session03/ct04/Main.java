package inflearn.session03.ct04;
import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String result = Stream.iterate(new int[]{1,1}, arr -> new int[]{arr[1], arr[0] + arr[1]})
                .limit(n)
                .map(arr -> arr[0])
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(result);

    }

}
