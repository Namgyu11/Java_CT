package codingTest.programmers.lv2.이모티콘할인행사;

import java.util.*;

class Solution {
    static int bestPlus, bestSales;
    static int[] discountRates = {10, 20, 30, 40};

    public int[] solution(int[][] users, int[] emoticons) {
        bestPlus = 0;
        bestSales = 0;
        int[] currentConfig = new int[emoticons.length];
        dfs(0, currentConfig, users, emoticons);
        return new int[]{bestPlus, bestSales};
    }

    private void dfs(int index, int[] currentConfig, int[][] users, int[] emoticons) {
        if(index == emoticons.length) {
            int[] result = simulate(currentConfig, users, emoticons);
            int plus = result[0];
            int sales = result[1];
            if(plus > bestPlus) {
                bestPlus = plus;
                bestSales = sales;
            } else if(plus == bestPlus && sales > bestSales) {
                bestSales = sales;
            }
            return;
        }
        for (int rate : discountRates) {
            currentConfig[index] = rate;
            dfs(index + 1, currentConfig, users, emoticons);
        }
    }

    private int[] simulate(int[] currentConfig, int[][] users, int[] emoticons) {
        int plusCount = 0;
        int totalSales = 0;
        for (int[] user : users) {
            int discountThreshold = user[0];
            int priceThreshold = user[1];
            int sum = 0;
            for (int i = 0; i < emoticons.length; i++) {
                int discount = currentConfig[i];
                if(discount >= discountThreshold) {
                    sum += emoticons[i] * (100 - discount) / 100;
                }
            }
            if(sum >= priceThreshold) {
                plusCount++;
            } else {
                totalSales += sum;
            }
        }
        return new int[]{plusCount, totalSales};
    }
}
