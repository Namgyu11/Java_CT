package codingTest.CT.CT05.ct03;


//23-11-10 (풀이) @@@@@@@@ 다시 풀기 @@@@@@@@@
class Solution {
    public int solution(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (right > left) {
            int pivot = (left + right) / 2;
            if (arr[pivot] < arr[pivot + 1]) {
                left = pivot + 1;
            } else {
                right = pivot;
            }
        }

        return (right != arr.length - 1) ? right : -1;
    }
}
