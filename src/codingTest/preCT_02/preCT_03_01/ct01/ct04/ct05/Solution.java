package codingTest.preCT_02.preCT_03_01.ct01.ct04.ct05;

//23-10-06(풀이) - 다시 풀기
class Solution {
    public static int solution(int n, int price) {
       int sets = n/11;
       int reminder = n % 11;

       int cost = sets  * price * 10;

       if(reminder != 0){
           cost += reminder * price;
       }
       return cost;
    }

    public static void main(String[] args) {
        int n = 20;
        int pr = 5;
        System.out.println(solution(n,pr));
    }
}

