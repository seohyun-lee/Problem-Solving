import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int ans;
    static int[] dx = {-1, 1, 0, 0}; // up / down
    static int[] dy = {0, 0, -1, 1}; // left / right

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 5, board);
        System.out.println(ans);
    }
    
    static void dfs(int count, int limit, int[][] board){
        if(count==limit){ // 종료조건
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    ans = Math.max(ans, board[i][j]);
                }
            }
            return;
        }
        
        for(int i=0; i<4; i++) { // 상하좌우 네 방향 시도
            // 준비
            // 같은 턴에서 합쳐졌는지 여부를 확인하기 위함
            boolean[][] isMerged = new boolean[n][n];
            // 보드는 복사해서 사용해야 함
            int[][] now = new int[n][n];
            for(int p=0; p<n; p++) {
                System.arraycopy(board[p], 0, now[p], 0, n);
            }
            
            // 어느 방향으로 움직일까?
            if(i==0 || i==2){ // 위, 왼쪽
                for(int p=0; p<n; p++) {
                    for (int j=0; j<n; j++) {
                        move(now, isMerged, i, p, j);
                    }
                }
            } else if (i==1 || i==3) { // 아래, 오른쪽
                for(int p=n-1; p>=0; p--) {
                    for (int j=n-1; j>=0; j--) {
                        move(now, isMerged, i, p, j);
                    }
                }
            }
            dfs(count+1, limit, now);
        }
    }
    
    // (p,j)에서 시작한 블록을 i 방향으로 이동
    static void move(int[][] now, boolean[][] isMerged, int i, int p, int j) {
        // 현재 블록 좌표
        int ni = p;
        int nj = j;
        // 이동할 블록 좌표
        int moveRow = ni+dx[i];
        int moveCol = nj+dy[i];
        // 경계 밖이면 이동 불가->종료
        if(moveCol<0||moveRow<0||moveCol>=n||moveRow>=n){
            return;
        }
        
        boolean end=false; // 플래그
        while(!end){
            if(now[moveRow][moveCol]==0){
                // 다음 칸이 비어 있으면 이동
                now[moveRow][moveCol] = now[ni][nj];
                now[ni][nj]=0;
                ni=moveRow;
                nj=moveCol;
                moveRow = ni+dx[i];
                moveCol = nj+dy[i];
                if(moveCol<0||moveRow<0||moveCol>=n||moveRow>=n){
                    end=true;
                }
            } else if (now[moveRow][moveCol] == now[ni][nj]) {
                if(!isMerged[moveRow][moveCol]) {
                    now[moveRow][moveCol] *= 2;
                    now[ni][nj]=0;
                    isMerged[moveRow][moveCol]=true;
                }
                end=true;
            } else {
                end=true;
            }
        }
    }
}