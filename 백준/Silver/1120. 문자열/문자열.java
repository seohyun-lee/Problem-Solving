import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        int lenA = A.length();
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i <= B.length() - lenA; i++) {
            int diff = 0;
            for (int j = 0; j < lenA; j++) {
                if (A.charAt(j) != B.charAt(i + j)) {
                    diff++;
                }
            }
            answer = Math.min(answer, diff);
        }
        System.out.println(answer);
    }
}
