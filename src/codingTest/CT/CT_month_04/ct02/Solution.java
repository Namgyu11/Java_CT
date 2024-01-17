package codingTest.CT.CT_month_04.ct02;


//24-01-14(풀이) - 다시 풀기 - 세그먼트 트리

public class Solution {
    long[] tree, lazy;

    void update_lazy(int node, int start, int end) {
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    void update_range(int node, int start, int end, int left, int right, long diff) {
        update_lazy(node, start, end);
        if (left > end || right < start) return;
        if (left <= start && end <= right) {
            tree[node] += (end - start + 1) * diff;
            if (start != end) {
                lazy[node * 2] += diff;
                lazy[node * 2 + 1] += diff;
            }
            return;
        }
        int mid = (start + end) / 2;
        update_range(node * 2, start, mid, left, right, diff);
        update_range(node * 2 + 1, mid + 1, end, left, right, diff);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    long sum(int node, int start, int end, int left, int right) {
        update_lazy(node, start, end);
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
    }

    public long[] solution(int N, int M, int[][] students, int[][] queries) {
        int len = 300001;
        tree = new long[len * 4];
        lazy = new long[len * 4];
        long[] answer = new long[M];

        for (int[] student : students) {
            update_range(1, 0, len - 1, student[0], Math.min(student[0] + student[1] - 1, len - 1), 1);
        }

        for (int i = 0; i < M; i++) {
            answer[i] = sum(1, 0, len - 1, queries[i][0], queries[i][1]);
        }
        return answer;
    }
}
