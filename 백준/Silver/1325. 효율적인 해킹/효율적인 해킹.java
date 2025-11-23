import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int N, M;
    static int[] count;
    static int[] visited;
    static int visitId = 1; // 현재 visited하는 번호

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        count = new int[N+1];
        visited = new int[N+1];

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        
        // 방향: b -> a
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            count[i] = bfs(i);
            max = Math.max(max, count[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (count[i] == max) {
                sb.append(i).append(' ');
            }
        }
        System.out.println(sb);
    }

    static int bfs(int start) {
        visitId++;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = visitId;
        
        int cnt = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : graph[cur]) {
                if (visited[nxt] != visitId) { // 이번에 아직 방문 안 했는지
                    visited[nxt] = visitId;
                    cnt++;
                    q.add(nxt);
                }
            }
        }
        return cnt;
    }
}
