import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    static int[][] map;
    static boolean[][] isOuterAir;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Node {
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void markOuterAir(int n, int m) {
        isOuterAir = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        isOuterAir[0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!isOuterAir[nx][ny] && map[nx][ny] == 0) {
                        isOuterAir[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    static boolean canMelt(int x, int y, int n, int m) {
        int count = 0;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (map[nx][ny] == 0 && isOuterAir[nx][ny]) {
                    count++;
                }
            }
        }
        return count >= 2;
    }

    static int meltCheese(int n, int m) {
        int time = 0;
        while (true) {
            markOuterAir(n, m);
            List<Node> toMelt = new ArrayList<>();
            boolean hasCheese = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1) {
                        hasCheese = true;
                        if (canMelt(i, j, n, m)) {
                            toMelt.add(new Node(i, j));
                        }
                    }
                }
            }
            if (!hasCheese) break;
            for (Node node : toMelt) {
                map[node.x][node.y] = 0;
            }
            time++;
        }
        return time;
    }

    void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
        int time = meltCheese(n, m);
        System.out.println(time);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}