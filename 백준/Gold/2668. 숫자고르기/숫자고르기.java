import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;
    static Set<Integer> result = new TreeSet<>(); // 자동 정렬 + 중복 제거

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        finished = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine()) - 1;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) dfs(i);
        }
        System.out.println(result.size());
        for (int num : result) {
            System.out.println(num + 1); // index 복원
        }
    }

    static void dfs(int curr) {
        visited[curr] = true;
        int next = arr[curr];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            extractCycle(next, curr);
        }
        finished[curr] = true;
    }

    static void extractCycle(int start, int end) {
        int node = start;
        result.add(node);
        while (node != end) {
            node = arr[node];
            result.add(node);
        }
    }
}
