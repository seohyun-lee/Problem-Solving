import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] space;
    static PriorityQueue<Shark> pq;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        space = new int[n][n];
        pq = new PriorityQueue<>();
        StringTokenizer st;
        Queue<Shark> queue = new LinkedList();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
                if (space[i][j] == 9) {
                    space[i][j] = 0;
                    queue.offer(new Shark(i, j, 0));
                }
            }
        }
        
        bfs(queue, 2);
        int move = 0;
        int cnt = 0;
        int sharkSize = 2;
        while (!pq.isEmpty()) {
            Shark now = pq.poll();
            space[now.x][now.y] = 0;
            if (++cnt == sharkSize) {
                cnt = 0;
                sharkSize++;
            }
            move += now.distance;
            queue = new LinkedList();
            queue.offer(new Shark(now.x, now.y, 0));
            bfs(queue, sharkSize);
        }
        System.out.println(move);
    }

    private static void bfs(Queue<Shark> queue, int sharkSize) {
        pq = new PriorityQueue<>();
        boolean visited[][] = new boolean[n][n];

        while (!queue.isEmpty()) {
            Shark now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || space[nx][ny] > sharkSize || visited[nx][ny])
                    continue;
                visited[nx][ny] = true;
                queue.offer(new Shark(nx, ny, now.distance + 1));
                if (space[nx][ny] != 0 && space[nx][ny] < sharkSize) {
                    pq.offer(new Shark(nx, ny, now.distance + 1));
                }
            }
        }
    }

    static class Shark implements Comparable<Shark> {
        int x, y, distance;
        Shark(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
        @Override
        public int compareTo(Shark o) {
            if (this.distance != o.distance)
                return Integer.compare(this.distance, o.distance);
            else {
                if (this.x == o.x) return Integer.compare(this.y, o.y);
                else return Integer.compare(this.x, o.x);
            }
        }
    }
}