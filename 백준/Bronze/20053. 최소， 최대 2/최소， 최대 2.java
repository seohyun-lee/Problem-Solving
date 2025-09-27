import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (num < min) 
                    min = num;
                if (num > max) 
                    max = num;
            }
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }
}
