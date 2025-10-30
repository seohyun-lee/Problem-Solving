import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 1자리 소수에서 시작
        int[] primes = {2, 3, 5, 7};
        for (int p : primes) {
            dfs(1, p);
        }
    }
    
    // curr이 소수인 경우 계속 탐색, digit이 n자리 도달 시 출력
    static void dfs(int digit, int curr) {
        if (!isPrime(curr))
            return;
        if (digit == n) {
            System.out.println(curr);
            return;
        }

        // 다음 자릿수 붙이기 (1~9)
        for (int i=1; i<=9; i++) {
            dfs(digit+1, curr*10+i);
        }
    }

    static boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i=2; i*i<=num; i++) {
            if (num%i==0)
                return false;
        }
        return true;
    }
}
