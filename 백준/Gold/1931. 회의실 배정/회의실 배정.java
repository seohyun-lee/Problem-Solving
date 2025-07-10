import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] meetings = new int[n][2];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }
        // 끝나는 시간이 작은 것부터 오름차순 정렬
        Arrays.sort(meetings, (a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        
        int count = 0, prevEnd = 0;
        for (int i=0; i<meetings.length; i++) {
            if (meetings[i][0] >= prevEnd) {
                prevEnd = meetings[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}