package codingTest.CT.CT01.ct02;


import java.util.HashSet;

//23-10-12(풀이) - 다시 풀기!
// 조합 < 수학적 지식 활용 < DP
public class Solution {
    public static int solution(String[] names) {
        HashSet<String> hashSet = new HashSet<>();
        for(String s : names){
            hashSet.add(s);
        }

        int size = hashSet.size();

        if(size < 4) {
            return 0;
        }

        long[][] comb = new long[size+1][5];

        for(int i=0; i<=size; i++) {
            comb[i][0] = 1;
            for(int j=1; j<=Math.min(i,4); j++) {
                comb[i][j] = (comb[i-1][j-1] + comb[i-1][j]);
            }
        }

        return (int)comb[size][4];
    }
    public static int fac(int n){
        if(n == 1){
            return 1;
        }
        return n * fac( n-1);
    }

    public static void main(String[] args) {
        String[] names = {"박민수", "김진영", "마봉춘", "김민주", "김진영", "박만수", "김진영", "김진영", "마봉춘", "김기수", "정진형", "김민주", "만수르", "백수르", "천수르", "만수르", "만수르", "만수르"};

        System.out.println(solution(names));
    }
}
