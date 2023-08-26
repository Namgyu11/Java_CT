package parctice.linearDS_10;// 선형 자료구조 - 데크


import java.util.ArrayDeque;
import java.util.Deque;

public class DequeTest {
    public static void main(String[] args) {
        Deque deque = new ArrayDeque();
        // Front 부분 입력
        deque.addFirst(1);
        System.out.println(deque);
        // Rear 부분 입력
        deque.addLast(10);
        System.out.println(deque);
        // Front 부분 출력
         System.out.println(deque.removeFirst());
        // Rear 부분 출력
        System.out.println(deque.removeLast());

    }
}
