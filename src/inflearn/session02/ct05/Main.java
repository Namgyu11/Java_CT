package inflearn.session02.ct05;

import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        char[] arr = input.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while(left < right){

            if(!Character.isAlphabetic(arr[left])){
                left++;
            }else if(!Character.isAlphabetic(arr[right])){
                right--;
            }else {
                char tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }
        }

        System.out.println(String.valueOf(arr));


    }
}
