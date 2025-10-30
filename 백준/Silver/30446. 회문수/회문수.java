import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());
        int digits = String.valueOf(n).length(); // 몇자리인지
        long count = 0;

        // 길이 digits 미만의 수들: 자릿수 단위로 계산
        for (int d = 1; d < digits; d++) {
            if (d == 1)
                count += 9;
            else
                count += 9 * (long) Math.pow(10, (d - 1) / 2);
        }

        // 길이 digits이고 n 이하인 것은 직접 세기
        long start = (long) Math.pow(10, (digits - 1) / 2);
        long end = (long) Math.pow(10, (digits + 1) / 2);
        for (long i = start; i < end; i++) {
            String s = String.valueOf(i); // i 즉 s는 왼쪽 절반
            String p = s + new StringBuilder(s.substring(0, digits % 2 == 0 ? s.length() : s.length() - 1)).reverse(); // 회문수
            if (Long.parseLong(p) <= n)
                count++;
        }
        System.out.println(count);
    }
}
