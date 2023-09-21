package codingTest.preCT_01.preCT_02.ct04;

//다시 풀기
class Solution {
    public static int solution(int[] orders, int n) {
        int i = 0;
        int orderNumber = 1;
        while (i < orders.length) {
            if (orders[i] == orderNumber) {
                i++;
            } else {
                n--;
                if (n == 0) return orderNumber;
            }
            orderNumber++;
        }

        while (n > 0) {
            n--;
            if (n == 0) return orderNumber;
            orderNumber++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] orders = {2,4,5,7};
        int n = 3;
        System.out.println(solution(orders,n));
    }
}
