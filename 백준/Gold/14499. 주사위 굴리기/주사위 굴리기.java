import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map; 

    static class Dice {
    	int top, up, down, left, right, bottom;
    
    	Dice(int top, int up, int down, int left, int right, int bottom) {
    		this.top = top;
    		this.up = up;
    		this.down = down;
    		this.left = left;
    		this.right = right;
    		this.bottom = bottom;
    	}
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        Dice curDice = new Dice(0, 1, 2, 3, 4, 5); // 주사위의 각 면을 "인덱스"로 관리
        int[] dice = new int[6]; // 주사위 각 면의 "값"을 저장
        
        // 동, 서, 북, 남 (동쪽, 남쪽이 증가하는 쪽)
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<k; i++) {
            int cmd = Integer.parseInt(st.nextToken());
            
            int t = curDice.top;
            int u = curDice.up;
            int d = curDice.down;
            int l = curDice.left;
            int r = curDice.right;
            int b = curDice.bottom;
            
            Dice nextDice;
            if (cmd == 1) { // 동쪽
                nextDice = new Dice(l, u, d, b, t, r);
            } else if (cmd == 2) { // 서쪽
                nextDice = new Dice(r, u, d, t, b, l);
            } else if (cmd == 3) { // 북쪽
                nextDice = new Dice(u, b, t, l, r, d);
            } else { // 남쪽
                nextDice = new Dice(d, t, b, l, r, u);
            }
            
            // 굴러갈 위치 (범위를 벗어나면 굴러가지 X)
            int nx = x + dx[cmd-1];
            int ny = y + dy[cmd-1];
			if(nx < 0 || nx >= n || ny < 0 || ny >= m) { 
				continue;
			}

			// 굴릴 수 있는 경우, 현재 주사위를 굴린 후의 주사위 상태로 변경
			curDice = nextDice;
			// 현 위치 갱신
			x = nx;
			y = ny;

			// 이동한 칸에 쓰여 있는 수가 0이면
			// 주사위의 바닥면에 쓰여 있는 수를 칸에 복사
			if(map[nx][ny] == 0) { 
				map[nx][ny] = dice[nextDice.bottom];
				System.out.println(dice[nextDice.top]);
			} else {
			    // 0이 아닌 경우에는
			    // 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 0이 쓰여짐
			    dice[nextDice.bottom] = map[nx][ny];
				map[nx][ny] = 0;
				System.out.println(dice[nextDice.top]);
			}
        }
        
    }
}