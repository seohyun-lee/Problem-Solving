import java.io.*;
import java.util.*;

public class Main {
    static final long INF = Long.MAX_VALUE;
    static TreeMap<Long, Long> map = new TreeMap<>();
    static long K;

    static Long findKey(long x) {
        Long left = map.floorKey(x);
        Long right = map.ceilingKey(x);
    
        long d1 = (left == null) ? INF : Math.abs(x - left);
        long d2 = (right == null) ? INF : Math.abs(x - right);
    
        long min = Math.min(d1, d2);
        if (min > K) return null;
    
        if (left != null && right != null && !left.equals(right) && d1 == d2) {
            return Long.MIN_VALUE;
        }
    
        return (d1 <= d2) ? left : right;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long key = Long.parseLong(st.nextToken());
            long value = Long.parseLong(st.nextToken());
            map.put(key, value);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                long key = Long.parseLong(st.nextToken());
                long value = Long.parseLong(st.nextToken());
                map.put(key, value);

            } else if (cmd == 2) {
                long key = Long.parseLong(st.nextToken());
                long value = Long.parseLong(st.nextToken());
                Long found = findKey(key);
                if (found != null && found != Long.MIN_VALUE) {
                    map.put(found, value);
                }

            } else {
                long key = Long.parseLong(st.nextToken());
                Long found = findKey(key);
                if (found == null) {
                    sb.append("-1\n");
                } else if (found == Long.MIN_VALUE) {
                    sb.append("?\n");
                } else {
                    sb.append(map.get(found)).append('\n');
                }
            }
        }
        System.out.print(sb);
    }
}
