import java.io.*;
import java.util.*;

public class Main {
    static final int MAX_H = 100001;
    static final long INF = Long.MAX_VALUE / 2;
    static int N, K;
    static long[] H, A, B;

    // 세그먼트 트리
    private static class SegmentTree {
        private static class Node {
            long val, lazy;
        }
        private final Node[] t;
        private final int n;
        public SegmentTree(int n) {
            this.n = n;
            t = new Node[4 * n];
            for (int i = 0; i < t.length; i++) t[i] = new Node();
        }
        private void push(int node, int s, int e) {
            if (t[node].lazy != 0) {
                t[node].val += (e - s + 1) * t[node].lazy;
                if (s != e) {
                    t[node * 2].lazy += t[node].lazy;
                    t[node * 2 + 1].lazy += t[node].lazy;
                }
                t[node].lazy = 0;
            }
        }
        private void pull(int node) {
            t[node].val = t[node * 2].val + t[node * 2 + 1].val;
        }
        public void update(int l, int r, long d) { update(1, 1, n, l, r, d); }
        private void update(int node, int s, int e, int l, int r, long d) {
            push(node, s, e);
            if (e < l || r < s) return;
            if (l <= s && e <= r) {
                t[node].lazy += d;
                push(node, s, e);
                return;
            }
            int m = (s + e) / 2;
            update(node * 2, s, m, l, r, d);
            update(node * 2 + 1, m + 1, e, l, r, d);
            pull(node);
        }
        public long query(int idx) { return query(1, 1, n, idx, idx); }
        private long query(int node, int s, int e, int l, int r) {
            push(node, s, e);
            if (e < l || r < s) return 0;
            if (l <= s && e <= r) return t[node].val;
            int m = (s + e) / 2;
            return query(node * 2, s, m, l, r) + query(node * 2 + 1, m + 1, e, l, r);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        H = new long[N + 1]; A = new long[N + 1]; B = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) H[i] = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) A[i] = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) B[i] = Long.parseLong(st.nextToken());

        SegmentTree coeffTree = new SegmentTree(MAX_H - 1);
        SegmentTree constTree = new SegmentTree(MAX_H - 1);
        long ans = INF;

        for (int i = 1; i <= N; i++) {
            updateCost(coeffTree, constTree, (int) H[i], A[i], B[i], 1);
            if (i >= K) {
                ans = Math.min(ans, findMinCost(coeffTree, constTree, 1, MAX_H - 1));
                int oldIdx = i - K + 1;
                updateCost(coeffTree, constTree, (int) H[oldIdx], A[oldIdx], B[oldIdx], -1);
            }
        }
        System.out.println(ans);
    }
    
    // 비용 갱신 함수
    private static void updateCost(SegmentTree coeffTree, SegmentTree constTree, int h, long a, long b, int sign) {
        coeffTree.update(1, h - 1, -b * sign);
        constTree.update(1, h - 1, b * h * sign);
        coeffTree.update(h, MAX_H - 1, a * sign);
        constTree.update(h, MAX_H - 1, -a * h * sign);
    }

    // 현재 윈도우의 비용함수에서 최솟값 찾기(삼분탐색)
    private static long findMinCost(SegmentTree coeffTree, SegmentTree constTree, int s, int e) {
        long res = INF;
        while (s + 2 < e) {
            int p = s + (e - s) / 3, q = e - (e - s) / 3;
            long cp = coeffTree.query(p) * p + constTree.query(p);
            long cq = coeffTree.query(q) * q + constTree.query(q);
            if (cp > cq) s = p;
            else e = q;
        }
        for (int h = s; h <= e; h++)
            res = Math.min(res, coeffTree.query(h) * h + constTree.query(h));
        return res;
    }
}
