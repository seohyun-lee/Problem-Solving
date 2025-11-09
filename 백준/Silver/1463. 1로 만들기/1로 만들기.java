import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + 1;    // (기본) 1을 빼는 경우
            if (i % 2 == 0)         // 2로 나누어 떨어지는 경우
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            if (i % 3 == 0)         // 3으로 나누어 떨어지는 경우
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }
        System.out.println(dp[n]);
    }
}

/*
DP 문제. 점화식을 세운다.
dp[i] = dp[i-1] + 1
if (i % 2 == 0) dp[i] = min(dp[i], dp[i/2] + 1)
if (i % 3 == 0) dp[i] = min(dp[i], dp[i/3] + 1)
*/