import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] a;

    static boolean can(int cap) {
        int cnt = 1, sum = 0;
        for (int x : a) {
            if (sum + x > cap) {
                cnt++;
                sum = 0;
            }
            sum += x;
        }
        return cnt <= m;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n];
        st = new StringTokenizer(br.readLine());

        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            l = Math.max(l, a[i]);
            r += a[i];
        }

        int ans = r;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (can(mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
