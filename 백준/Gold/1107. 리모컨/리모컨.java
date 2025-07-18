import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] btns = new boolean[10];
        Arrays.fill(btns, true);
        if (m>0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0; i<m; i++) {
                int broken = Integer.parseInt(st.nextToken());
                btns[broken] = false;
            }
        }
        
        // 100인 경우 바로 종료
        if (n==100) {
            System.out.println(0);
            return;
        }
        // 100으로부터 +-만으로 이동하는 경우
        long minCount = Math.abs(n-100);
        // 0~999999 누를 수 있는 조합을 확인
        for(int i=0; i<=999999; i++) {
            String numStr = String.valueOf(i);
            boolean canPress = true;
            for(int j=0; j<numStr.length(); j++) {
                if(!btns[numStr.charAt(j)-'0']){
                    canPress = false;
                    break;
                }
            }
            if (canPress) {
                minCount = Math.min(minCount, numStr.length() + Math.abs(n-i));
            }
        }
        System.out.println(minCount);
    }
    
	public static void main(String[] args) throws Exception {
	    new Main().solution();
	}
}