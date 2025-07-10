import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        int[] answers = new int[t];
        
        for(int j=0; j<t; j++) {
            int n = Integer.parseInt(br.readLine());
            int[][] scores = new int[n][2];
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                scores[i][0] = Integer.parseInt(st.nextToken());
                scores[i][1] = Integer.parseInt(st.nextToken());
            }
            // 서류를 기준으로 오름차순 정렬
            Arrays.sort(scores, (a, b) -> Integer.compare(a[0], b[0]));
            
            int count = 0, min = scores.length;
            for (int i=0; i<scores.length; i++) {
                if (min >= scores[i][1]) {
                    min = scores[i][1];
                    count++;
                }
            }
            answers[j] = count;
        }
        for (int j=0; j<t; j++) {
            System.out.println(answers[j]);
        }
    }
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}