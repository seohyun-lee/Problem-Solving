import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] dp = new int[12]; // n 최대 11
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 7;
        // 점화식: dp[n] = dp[n-1](끝에 1 붙임) + dp[n-2](끝에 2 붙임) + dp[n-3](끝에 3 붙임)
        // 중복이 발생하지 않는 이유: 순서가 다르면 다른 방법.(순열 개념)
        for(int i=5; i<=11; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        for (int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}
