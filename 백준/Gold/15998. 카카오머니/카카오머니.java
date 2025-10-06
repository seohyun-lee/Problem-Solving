import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long prev = 0;
        long M = 0;
        boolean valid = true;
        List<long[]> logs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long expected = prev + a;

            if (expected != b) {  // 충전 발생
                long diff = b - expected;
                if (diff <= 0) { 
                    valid = false; 
                    break;
                }
                M = (M == 0) ? diff : gcd(M, diff);
            }
            prev = b;
            logs.add(new long[]{a, b});
        }

        if (!valid) {
            System.out.println(-1);
            return;
        }

        if (M == 0) { // 충전 불필요
            System.out.println(1);
            return;
        }

        // 검증
        prev = 0;
        for (long[] t : logs) {
            long a = t[0], b = t[1];
            long expected = prev + a;
            if (expected < 0) 
                expected += ((-expected + M - 1) / M) * M;
            if (expected != b) { // 최종 잔액 불일치
                System.out.println(-1);
                return;
            }
            prev = b;
        }
        System.out.println(M);
    }
    
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
