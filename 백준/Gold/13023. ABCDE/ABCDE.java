import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean found = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (found) break;
        }

        System.out.println(found ? 1 : 0);
    }

    static void dfs(int node, int depth) {
        if (found) return; // 이미 찾았으면 중단
        if (depth == 5) {
            found = true;
            return;
        }

        visited[node] = true;
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }
        visited[node] = false;
    }
}
