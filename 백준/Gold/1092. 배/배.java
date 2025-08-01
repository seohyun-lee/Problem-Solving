import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] crane = new Integer[n];
        String[] sb = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            crane[i] = Integer.parseInt(sb[i]);
        }
        Arrays.sort(crane, Collections.reverseOrder());

        int m = Integer.parseInt(br.readLine());
        Integer[] box = new Integer[m];
        sb = br.readLine().split(" ");
        for(int i=0; i<m; i++) {
            box[i] = Integer.parseInt(sb[i]);
            if (box[i] > crane[0]) {
                System.out.println(-1);
                return;
            }
        }
        Arrays.sort(box, Collections.reverseOrder());

        boolean[] used = new boolean[m];
        int[] pos = new int[n];
        int moved = 0;
        int time = 0;

        while (moved < m) {
            for (int i = 0; i < n; i++) {
                while (pos[i] < m) {
                    if (!used[pos[i]] && crane[i] >= box[pos[i]]) {
                        used[pos[i]] = true;
                        moved++;
                        pos[i]++;
                        break;
                    }
                    pos[i]++;
                }
            }
            time++;
        }
        System.out.println(time);
    }
}