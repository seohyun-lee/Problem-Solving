import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] board;
    static int[][] dp;
    static boolean[][] visited;
    static boolean isInfinite;

    public static int dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] == 0) {
            return 0;
        }
        // 현재 경로에 이미 방문했다면 사이클
        if (visited[x][y]) {
            isInfinite = true;
            return 0;
        }
        // 이미 dp에 계산한 값이 있는 경우 바로 리턴
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        visited[x][y] = true;
        int num = board[x][y];
        int maxDepth = 0;
        
        maxDepth = Math.max(maxDepth, dfs(x + num, y));
        maxDepth = Math.max(maxDepth, dfs(x - num, y));
        maxDepth = Math.max(maxDepth, dfs(x, y + num));
        maxDepth = Math.max(maxDepth, dfs(x, y - num));

        dp[x][y] = maxDepth + 1;
        visited[x][y] = false;
        return dp[x][y];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        board = new int[n][m];
        dp = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);
                if (c == 'H') c = '0';
                board[i][j] = Character.getNumericValue(c);
                dp[i][j] = -1;
            }
        }

        int ans = dfs(0, 0);
        if (isInfinite)
            System.out.println(-1);
        else
            System.out.println(ans);
    }
}
