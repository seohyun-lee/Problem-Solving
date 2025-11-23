import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int[] color;
    static int V, E;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            graph = new ArrayList[V + 1];
            for (int i = 1; i <= V; i++) 
                graph[i] = new ArrayList<>();
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }
            color = new int[V+1]; // 0: 미방문, 1/-1: 두 그룹
            if (check()) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.print(sb.toString());
    }

    static boolean check() {
        for (int i = 1; i <= V; i++) {
            if (color[i] == 0) {
                if (!bfs(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        color[start] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (color[next] == 0) {
                    color[next] = -color[cur]; // 반대 색으로 칠하기
                    q.add(next);
                } else {
                    if (color[next] == color[cur]) { // 이미 색이 있는데, 인접한 두 정점의 색이 같다면 이분 그래프 X
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
