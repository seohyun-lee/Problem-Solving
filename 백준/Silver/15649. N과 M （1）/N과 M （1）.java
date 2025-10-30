import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static boolean[] visited;
    static int[] nums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1]; // n번이 사용되었는지를 확인 (1~n)
        nums = new int[m];
        for(int i=1; i<=n; i++) {
            dfs(i, 0);
        }
    }

    static void dfs(int curr, int idx) {
        if(visited[curr]) {
            return;
        }
        visited[curr] = true;
        nums[idx]=curr;
        if(idx==m-1){
            for(int i=0; i<m; i++) {
                System.out.print(nums[i]+" ");
            }
            System.out.println();
        } else {
            for(int i=1; i<=n; i++){
                dfs(i, idx+1);
            }
        }
        visited[curr] = false;
    }
}
