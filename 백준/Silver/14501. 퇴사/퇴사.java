import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static int[] dp; // 특정 날짜까지의 최대 수입

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        dp = new int[n+1];
        for(int i=0; i<n; i++){
            String[] s = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }
        for(int i=0; i<n; i++){
            int nextIdx = i+arr[i][0];
            for(int j=nextIdx; j<n+1; j++){
                dp[j] = Math.max(dp[j], dp[i]+arr[i][1]);
            }
        }
        System.out.println(dp[n]);
    }
}
