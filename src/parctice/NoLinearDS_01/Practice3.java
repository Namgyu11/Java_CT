package parctice.NoLinearDS_01;// Practice3
// 트리 구조 복습 / 구현

import java.util.LinkedList;
import java.util.Queue;

class Node2{

    char data;
    Node2 left;
    Node2 right;
    Node2 parent;

    public Node2(char data, Node2 left, Node2 right, Node2 parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}
class BinaryTree3 {

    Node2 head;

    BinaryTree3(char[] arr){
        Node2[] nodes = new Node2[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node2(arr[i], null, null, null);
        }
        for (int i = 0; i < arr.length; i++) {
            int left = 2 * i + 1; //자식 노드 인덱스 찾기
            int right = 2 * i + 2;

            if(left < arr.length){ //범위 비교
                nodes[i].left = nodes[left];
                nodes[left].parent = nodes[i];
            }

            if(right < arr.length){
                nodes[i].right = nodes[right];
                nodes[right].parent = nodes[i];
            }
        }
        this.head = nodes[0];
    }

    public Node2 searchNode(char data){
        Queue<Node2> queue = new LinkedList<>();

        queue.add(this.head);
        while (!queue.isEmpty()){
            Node2 cur = queue.poll();
            if(cur.data == data){
                return cur;
            }
            if(cur.left != null){
                queue.offer(cur.left);
            }

            if(cur.left != null){
                queue.offer(cur.right);
            }
        }
        return null;
    }
}

public class Practice3 {

    public static void main(String[] args) {
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)('A' + i);
        }

        BinaryTree3 bt = new BinaryTree3(arr);

        // Root node

        System.out.println("Root: " + bt.head.data);


        // B's child node
        Node2 B = bt.searchNode('B');


        // F's parent node



        // Leaf node



        // E's Depth



        // Level2 Node



        // Height



        // B's Size


    }
}
