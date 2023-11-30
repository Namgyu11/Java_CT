package codingTest.CT.CT07.ct04;

import java.util.*;
//23-11-24(풀이)  - @@다시 풀어보기@@ - 깊이 우선 탐색

public class Solution {
    public int[] solution(String nums) {
        List<Integer> list = new ArrayList<>();
        // 만약 유사 피보나치 수열을 찾았다면 list를 배열로 변환하여 반환, 아니라면 빈 배열 반환
        if (dfs(nums, list, 0)) {
            return list.stream().mapToInt(i -> i).toArray();
        } else {
            return new int[0];
        }
    }

    private boolean dfs(String nums, List<Integer> list, int idx) {
        // 유사 피보나치 수열은 최소 3개의 숫자로 이루어져야 함.
        // 모든 문자를 사용하였고, list의 크기가 3 이상이라면 true 반환
        if (idx == nums.length() && list.size() >= 3) {
            return true;
        }

        for (int i = idx; i < nums.length(); i++) {
            // 숫자가 0으로 시작하는 경우는 무시
            if (nums.charAt(idx) == '0' && i > idx) {
                break;
            }
            // 현재 인덱스부터 i까지의 부분 문자열을 숫자로 변환
            long num = Long.parseLong(nums.substring(idx, i + 1));
            // 숫자가 Integer 범위를 벗어나면 반복 종료
            if (num > Integer.MAX_VALUE) {
                break;
            }
            int size = list.size();
            // 만약 현재 만든 숫자가 이전 두 숫자의 합보다 크다면, 더 이상 진행할 필요가 없으므로 반복문을 종료
            if (size >= 2 && num > list.get(size - 1) + list.get(size - 2)) {
                break;
            }
            // 만약 현재 만든 숫자가 이전 두 숫자의 합과 같다면, 리스트에 숫자를 추가하고 다음 숫자를 찾기 위해 재귀 호출
            if (size <= 1 || num == list.get(size - 1) + list.get(size - 2)) {
                list.add((int) num);
                // 재귀 호출이 true를 반환한다면, 유사 피보나치 수열을 찾은 것이므로 현재 함수도 true를 반환
                if (dfs(nums, list, i + 1)) {
                    return true;
                }
                // 그렇지 않다면, 리스트에서 마지막에 추가한 숫자를 제거하고 다음 숫자를 만들기 위해 반복문을 계속 진행
                list.remove(list.size() - 1);
            }
        }
        return false;
    }


}
