import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long K = Long.parseLong(br.readLine());

        String bin = Long.toBinaryString(K+1);

        // 맨 앞 '1'은 버리고 나머지를 0→4, 1→7로 치환
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < bin.length(); i++) {
            if (bin.charAt(i) == '0') sb.append('4');
            else sb.append('7');
        }

        System.out.println(sb.toString());
    }
}
