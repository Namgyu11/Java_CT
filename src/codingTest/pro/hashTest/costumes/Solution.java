package codingTest.pro.hashTest.costumes;

import java.util.HashMap;
/*코딩테스트 연습 - 해시 - 의상
*/
public class Solution {
    public static int solution(String[][] clothes) {

        //int answer = 0;
        HashMap<String, Integer> hashMap = new HashMap();

        for (int i = 0; i < clothes.length; i++) {
            if (hashMap.containsKey(clothes[i][1])) {
                hashMap.put(clothes[i][1], hashMap.get(clothes[i][1]) + 1);
            } else {
                hashMap.put(clothes[i][1], 1);
            }
        }

//        int cnt1 = 0;
//        int cnt2 = 1;
//        for(Integer val : hashMap.values()){
//           if(val != null) {
//               cnt1 += val;
//               cnt2 *= val;
//           }
//        }
        //answer = cnt1 + cnt2;

        int answer = 1;

        for (Integer val : hashMap.values()) {
            if (val != null) { // null 체크 추가
                answer *= (val + 1);
            }
        }


        return answer - 1;
    }

    public static void main(String[] args) {

        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        System.out.println(solution(clothes));
    }
}
