import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] box;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) { // 익은 토마토 위치 저장
                    q.add(new int[]{i, j});
                }
            }
        }

        // BFS 탐색으로 익힘 전파
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];
            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if (nx < 0 || ny < 0 || nx >= M || ny >= N) 
                    continue;
                if (box[ny][nx] == 0) {
                    box[ny][nx] = box[y][x] + 1;
                    q.add(new int[]{ny, nx});
                }
            }
        }
        
        // 결과 계산
        int days = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) { // 익지 않은 토마토 존재하면 종료
                    System.out.println(-1);
                    return;
                }
                days = Math.max(days, box[i][j]);
            }
        }

        System.out.println(days-1); // 첫 날이 1로 시작했으므로 -1해 보정
    }
}
