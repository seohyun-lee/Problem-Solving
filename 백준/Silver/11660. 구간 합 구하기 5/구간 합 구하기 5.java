import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] nm = br.readLine().split(" ");
	    int n = Integer.parseInt(nm[0]);
	    int m = Integer.parseInt(nm[1]);
	    
	    int[][] board = new int[n+1][n+1];
	    int[][] sum = new int[n+1][n+1];
	    for(int i=1; i<=n; i++) {
	        String[] nums = br.readLine().split(" ");
	        for(int j=1; j<=n; j++) {
	            board[i][j] = Integer.parseInt(nums[j-1]);
	            sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + board[i][j];
	        }
	    }
	    for(int i=0; i<m; i++) {
	        String[] input = br.readLine().split(" ");
	        int x1 = Integer.parseInt(input[0]);
	        int y1 = Integer.parseInt(input[1]);
	        int x2 = Integer.parseInt(input[2]);
	        int y2 = Integer.parseInt(input[3]);
	        int ans = sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1];
	        System.out.println(ans);
	    }
	}
}