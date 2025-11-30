import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            String best = br.readLine();
            for (int i = 1; i < n; i++) {
                String cur = br.readLine();
                if (cur.toLowerCase().compareTo(best.toLowerCase()) < 0)
                    best = cur;
            }
            System.out.println(best);
        }
    }
}