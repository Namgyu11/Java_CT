package codingTest.preCT_03.preCT_03_03.preCT_03_05.ct05;

import java.util.ArrayList;

public class Solution {
    public static int[] solution(int[] arr) {
        int[] coins = {500, 100, 50, 10};
        int lastBill = -1;
        int totalMoney = 0;

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = arr.length - 1; i >=0; i--) {
            if (arr[i] >= 1000) {
                lastBill = arr[i];
            }
            totalMoney += arr[i];
        }

        if (lastBill != -1) {
            totalMoney -= lastBill;
            result.add(lastBill);
        }

        for (int coin : coins) {
            while(totalMoney >= coin){
                result.add(coin);
                totalMoney -= coin;
            }
        }

        return result.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int[] arr ={1000,1000,100};
        System.out.println(solution(arr));
    }
}
