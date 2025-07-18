import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        boolean[][] board = new boolean[101][101];
        
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            List<Integer> intArr = new ArrayList<>();
            int currDir = d;
            for(int j=0; j<=g; j++) {
                if (j==0)
                    intArr.add(currDir);
                else {
                    for(int l=intArr.size()-1; l>=0; l--) { // 2*g-1번 수행됨
                        currDir = (intArr.get(l)+1)%4;
                        intArr.add(currDir);
                    }
                }
            }
            int[][] move = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
            board[x][y] = true;
            for (int j=0; j<intArr.size(); j++) {
                x += move[intArr.get(j)][0];
                y += move[intArr.get(j)][1];
                if (x>=0 && x <= 100 && y>=0 && y <= 100)
                    board[x][y] = true;
            }
        }
        int count = 0;
        for(int i=0; i<100; i++) {
            for (int j=0; j<100; j++) {
                if(board[i][j] && board[i+1][j] && board[i][j+1] && board[i+1][j+1])
                    count++;
            }
        }
        System.out.println(count);
    }
    
	public static void main(String[] args) throws Exception {
	    new Main().solution();
	}
}