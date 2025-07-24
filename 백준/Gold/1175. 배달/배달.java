import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    static class Node {
        int x, y, dir, time, delivered;
        
        public Node(int x, int y, int dir, int time, int delivered) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.time = time;
            this.delivered = delivered;
        }
    }
    
    static int n, m;
    static char[][] map;
    static int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static int[][] giftPos = new int[2][2];
    
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        map = new char[n][m];
        
        int sx=0, sy=0, giftIdx=0;
        for(int i=0; i<n; i++) {
            String line = br.readLine();
            for(int j=0; j<m; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'S') {
                    sx = j;
                    sy = i;
                } else if (map[i][j] == 'C') {
                    giftPos[giftIdx][0] = j;
                    giftPos[giftIdx++][1] = i;
                }
            }
        }
        int result = bfs(sx, sy);
        System.out.println(result);
    }
    
    static int bfs(int sx, int sy) {
        Queue<Node> q = new LinkedList<>();
        boolean[][][][] visited = new boolean[n][m][4][4]; // y, x, 방향, 배달한 선물 비트마스크
        
        q.add(new Node(sx, sy, -1, 0, 0)); // 시작점
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.delivered == 0b11) // 모두 배달 완료
                return cur.time;
           
            for (int d = 0; d < 4; d++) {
                if (d == cur.dir)
                    continue;
                int nx = cur.x + dirs[d][0];
                int ny = cur.y + dirs[d][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] != '#') {
                    int nextDelivered = checkDelivered(nx, ny, cur.delivered); // 다음 선물 배달 상태
                    if (!visited[ny][nx][d][nextDelivered]) {
                        visited[ny][nx][d][nextDelivered] = true;
                        q.add(new Node(nx, ny, d, cur.time+1, nextDelivered));
                    }
                }
            }
        }
        return -1;
    }
    
    static int checkDelivered(int x, int y, int delivered) {
        if (x == giftPos[0][0] && y == giftPos[0][1]) delivered |= 0b01; //	첫 번째 C를 감
        if (x == giftPos[1][0] && y == giftPos[1][1]) delivered |= 0b10; // 두 번째 C를 감
        return delivered;
    }
}