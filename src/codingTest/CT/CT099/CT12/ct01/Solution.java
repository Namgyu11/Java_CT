package codingTest.CT.CT099.CT12.ct01;

//23-12-28(풀이) - 다시 풀기
public class Solution {
    public static int solution(String s) {
        char[] arr = s.toCharArray();
        int answer = 0, left = 0, right = arr.length - 1;
        // 'a' 문자가 아닌 경계를 찾는다.
        while (left < right) {
            if (arr[left] != 'a') {
                left++;
                answer++;
            }
            if (arr[right] != 'a') {
                right--;
                answer++;
            }
            // 'a' 문자를 만나면 경계를 확장한다.
            if (arr[left] == 'a') left++;
            if (arr[right] == 'a') right--;
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "azbacefbaaaa";
        System.out.println(solution(s));

    }
}
