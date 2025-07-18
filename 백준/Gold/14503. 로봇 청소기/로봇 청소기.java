import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        int[][] board = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        int[][] dir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        while (true) {
            if (board[r][c] == 0) {
                board[r][c] = -1;
                count++;
            }
            boolean flag = false;
            for(int i=0; i<4; i++) {
                int lookx = r+dir[(4-d+i)%4][0];
                int looky = c+dir[(4-d+i)%4][1];
                if (board[lookx][looky] == 0) {
                    r = lookx;
                    c = looky;
                    d = (4+d-(i+1))%4;
                    flag = true;
                    // System.out.println("loc: " + r + ", " + c + ": " + d);
                    break;
                }
            }
            if (flag == true)
                continue;
            
            if (d==0 && board[r+1][c] != 1)
                r++;
            else if (d==1 && board[r][c-1] != 1)
                c--;
            else if (d==2 && board[r-1][c] != 1)
                r--;
            else if (d==3 && board[r][c+1] != 1)
                c++;
            else
                break;
        }
        System.out.println(count);
    }
    
	public static void main(String[] args) throws Exception {
	    new Main().solution();
	}
}