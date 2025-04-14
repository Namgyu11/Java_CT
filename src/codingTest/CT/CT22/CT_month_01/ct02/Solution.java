package codingTest.CT.CT22.CT_month_01.ct02;

import java.util.Arrays;

//23-10-13(풀이) - 다시 풀기 (시간복잡도 이슈)
//  binary search 알고리즘을 사용
public class Solution {
    public static int[] solution(int N, int K, int[] arr, int[][] queries) {
        int[] answer = new int[K];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < queries.length; j++) {
                if (queries[j][0] <= arr[i] && queries[j][1] >= arr[i]) {
                    answer[j] += 1;
                }
            }
        }
        return answer;
    }
    public static int[] solution1(int N, int K, int[] arr, int[][] queries) {
        Arrays.sort(arr);
        int[] answer = new int[K];
        for (int i = 0; i < K; i++) {
            answer[i] = upperBound(arr, queries[i][1]) - lowerBound(arr, queries[i][0]);
        }
        return answer;
    }

    private static int lowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            final int mid = (low + high) / 2;
            if (arr[mid] >= target)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

    private static int upperBound(int[] arr, int target){
        int low=0;
        int high=arr.length;

        while(low<high){
            final int mid=(low+high)/2;

            if(arr[mid]<=target)
                low=mid+1;
            else
                high=mid;
        }

        return low;
    }

    public static void main(String[] args) {
        int N = 5;
        int K = 3;
        int[] arr = {7, 2, 3, 5, 2};
        int[][] queries = {{1, 100}, {3, 5}, {2, 2}};
        System.out.println(Arrays.toString(solution1(N, K, arr, queries)));
    }
}
