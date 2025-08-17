import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tw = br.readLine().split(" ");
        int T = Integer.parseInt(tw[0]);
        int W = Integer.parseInt(tw[1]);

        int[] drop = new int[T+1];
        for (int t = 1; t <= T; t++)
            drop[t] = Integer.parseInt(br.readLine());

        // dp[t][w] : t초까지 w번 이동했을 때 최대 자두
        int[][] dp = new int[T+1][W+1];

        for (int t = 1; t <= T; t++) {
            for (int w = 0; w <= W; w++) {
                int pos = (w % 2 == 0) ? 1 : 2; // w의 홀짝으로 위치 확인
                int gain = (drop[t] == pos) ? 1 : 0;
                // 이동 안 함
                dp[t][w] = dp[t-1][w]+gain;
                // 이동 함
                if (w > 0) {
                    dp[t][w] = Math.max(dp[t][w], dp[t-1][w-1]+gain);
                }
            }
        }
        int ans = 0;
        for (int w = 0; w <= W; w++)
            ans = Math.max(ans, dp[T][w]);
        System.out.println(ans);
    }
}
