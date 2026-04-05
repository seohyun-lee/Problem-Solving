class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, n, computers, visited);
                ans++;
            }
        }
        return ans;
    }

    static void dfs(int v, int n, int[][] computers, boolean[] visited) {
        visited[v] = true;
        for (int i = 0; i < n; i++)
            if (computers[v][i] == 1 && !visited[i])
                dfs(i, n, computers, visited);
    }
}