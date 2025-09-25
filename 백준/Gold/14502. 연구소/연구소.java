import java.io.*;
import java.util.*;

public class Main {
    static int n, m, ans;
    static int[][] board;
    static List<Node> virus;

    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        virus = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j]==2) {
                    virus.add(new Node(i, j));
                }
            }
        }

        ans = 0;
        dfs(0);
        System.out.println(ans);
    }

    // 벽 세우기 (DFS)
    static void dfs(int wallCount) {
        if (wallCount==3) {
            bfsAll();
            return;
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j]==0) {
                    board[i][j]=1; // 벽 세우기
                    dfs(wallCount+1);
                    board[i][j]=0; // 되돌리기
                }
            }
        }
    }

    // 바이러스 퍼뜨리기 (BFS)
    static void bfsAll() {
        int[][] cpboard = new int[n][m];
        for (int i=0; i<n; i++) {
            cpboard[i] = board[i].clone();
        }

        Queue<Node> q = new LinkedList<>();
        for (Node v : virus) {
            q.add(new Node(v.x, v.y));
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        while (!q.isEmpty()) {
            Node p = q.poll();
            for (int i=0; i<4; i++) {
                int nx=p.x+dx[i];
                int ny=p.y+dy[i];
                if (nx>=0 && nx<n && ny>=0 && ny<m && cpboard[nx][ny]==0) {
                    cpboard[nx][ny]=2;
                    q.add(new Node(nx, ny));
                }
            }
        }

        int cnt = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (cpboard[i][j]==0)
                    cnt++;
            }
        }
        ans = Math.max(ans, cnt);
    }
}
