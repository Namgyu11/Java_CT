package codingTest.CT.CT_month_03.ct04;

import java.util.Arrays;


class Node {
    int key;
    parctice.NoLinearDS_02Bst.test.Node left;
    parctice.NoLinearDS_02Bst.test.Node right;

    Node(int key, parctice.NoLinearDS_02Bst.test.Node left, parctice.NoLinearDS_02Bst.test.Node right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
}

class BinarySearchTree {
    parctice.NoLinearDS_02Bst.test.Node head;

    BinarySearchTree() {}
    BinarySearchTree(int key) {
        this.head = new parctice.NoLinearDS_02Bst.test.Node(key, null, null);
    }

    public void addNode(int key) {
        this.head = this.addNode(this.head, key);
    }

    public parctice.NoLinearDS_02Bst.test.Node addNode(parctice.NoLinearDS_02Bst.test.Node cur, int key) {
        if (cur == null) {
            return new parctice.NoLinearDS_02Bst.test.Node(key, null, null);
        }

        if (key < cur.key) {
            cur.left = addNode(cur.left, key);
        } else {
            cur.right = addNode(cur.right, key);
        }

        return cur;
    }
}
public class test {



    public int solution(int money, int[] chips) {
        int[] dp = new int[money + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int chip : chips) {
            for (int j = chip; j <= money; j++) {
                if (dp[j - chip] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - chip] + 1);
            }
        }

        return dp[money] == Integer.MAX_VALUE ? -1 : dp[money];
    }

}
