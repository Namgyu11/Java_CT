package studyCT.CT03.ct01;

import java.util.*;

public class Solution {

  public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
    int n = rooms.size(); // 방의 개수
    boolean[] visited = new boolean[n]; // 방의 개수만큼 방문 여부를 저장할 배열
    visited[0] = true; // 0번 방은 처음부터 열려있음

    Stack<Integer> stack = new Stack<>();
    stack.push(0); // 0번 방부터 시작

    System.out.println("Start visiting rooms from room 0");

    while (!stack.isEmpty()) {
      int room = stack.pop(); // 방문할 방을 꺼냄
      System.out.println("Visiting room: " + room);
      for (int key : rooms.get(room)) {
        if (!visited[key]) {
          visited[key] = true; // 방문한 방은 true 로 변경
          stack.push(key); // 방문한 방의 열쇠를 스택에 삽입
          System.out.println("Found key for room: " + key);
        }
      }
    }

    for (int i = 0; i < visited.length; i++) { // 모든 방을 방문했는지 확인
      if (!visited[i]) { // 방문하지 않은 방이 있다면 false 반환
        System.out.println("Failed to visit all rooms, couldn't visit room: " + i);
        return false;
      }
    }
    System.out.println("Successfully visited all rooms!");
    return true; // 모든 방을 방문했다면 true 반환
  }

  public static void main(String[] args) {
    System.out.println(canVisitAllRooms(Arrays.asList(
        Arrays.asList(1,3),
        Arrays.asList(3,0,1),
        Arrays.asList(2),
        Arrays.asList(0),
        new ArrayList<>()
    )));
  }
}