package codingTest.programmers.lv3.길찾기게임;

import java.util.*;

class Solution {
    static class Node {
        int x, y, idx;
        Node left, right;
        Node(int x, int y, int idx) {
            this.x = x; this.y = y; this.idx = idx;
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        List<Node> nodes = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        }
        // y 내림차순, x 오름차순
        nodes.sort((a, b) -> b.y != a.y ? b.y - a.y : a.x - b.x);
        Node root = nodes.get(0);
        for (int i = 1; i < n; i++) {
            insert(root, nodes.get(i));
        }
        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        dfs(root, preorder, postorder);
        int[] pre = preorder.stream().mapToInt(i -> i).toArray();
        int[] post = postorder.stream().mapToInt(i -> i).toArray();
        return new int[][]{ pre, post };
    }
    
    private void insert(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insert(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insert(parent.right, child);
            }
        }
    }
    
    private void dfs(Node node, List<Integer> pre, List<Integer> post) {
        if (node == null) {
            return;
        }
        pre.add(node.idx);
        dfs(node.left, pre, post);
        dfs(node.right, pre, post);
        post.add(node.idx);
    }
}
