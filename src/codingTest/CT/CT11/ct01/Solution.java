package codingTest.CT.CT11.ct01;

//23-12-22(풀이) - 다시 풀기

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static int solution(int n, int num) {

        for (int i = 0; i < n; i++) {
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            StringBuilder stringBuilder = new StringBuilder();
            String str = String.valueOf(num);
            int[] nums = str.chars().map(Character::getNumericValue).toArray();

            for (int j : nums) {
                treeMap.put(j, treeMap.getOrDefault(j, 0) + 1);
            }

            for(Map.Entry<Integer,Integer> entry : treeMap.entrySet()){
                stringBuilder.append(entry.getKey());
                stringBuilder.append(entry.getValue());
            }

            num = Integer.parseInt(stringBuilder.toString());
        }


        return num % 10004;

    }

    public int solution1(int n, int num) {
        BigInteger bigNum = new BigInteger(String.valueOf(num));

        for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            String numStr = bigNum.toString();
            int[] nums = new int[10];

            for (char ch : numStr.toCharArray()) {
                nums[ch - '0']++;
            }

            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > 0) {
                    stringBuilder.append(j);
                    stringBuilder.append(nums[j]);
                }
            }

            bigNum = new BigInteger(stringBuilder.toString());
        }

        return bigNum.mod(new BigInteger("10004")).intValue();
    }
    public static void main(String[] args) {

        int n = 3;
        int num = 54223;

        System.out.println(solution(n, num));

    }
}
