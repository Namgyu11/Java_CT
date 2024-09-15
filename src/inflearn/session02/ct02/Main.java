package inflearn.session02.ct02;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String result = str.chars()
                .mapToObj(ch ->
                {
                    if (Character.isUpperCase(ch)) {
                        return Character.toLowerCase((char)ch);
                    } else {
                        return Character.toUpperCase((char)ch);
                    }
                })
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(result);
    }

}
