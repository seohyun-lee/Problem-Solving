import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        parent[find(x)] = find(y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return Integer.compare(b[1], a[1]);
            else return Integer.compare(a[0], b[0]);
        });
        int maxTime = 0;
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int d = Integer.parseInt(s[0]);
            int r = Integer.parseInt(s[1]);
            pq.offer(new int[]{d, r});
            if (d > maxTime) maxTime = d;
        }
        
        parent = new int[maxTime+2];
        for (int i=0; i<=maxTime+1; i++)
            parent[i] = i;

        int sum = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int available = find(curr[0]);
            if (available == 0) // 0인 경우 불가능
                continue;
            sum += curr[1];
            union(available, available-1);
        }
        System.out.println(sum);
    }
}
