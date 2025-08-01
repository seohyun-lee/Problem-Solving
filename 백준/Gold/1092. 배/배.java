import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] crane = new int[n];
        String[] sb = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            crane[i] = Integer.parseInt(sb[i]);
        }
        Arrays.sort(crane); // 오름차순 정렬
        int m = Integer.parseInt(br.readLine());
        List<Integer> box = new ArrayList<>();
        sb = br.readLine().split(" ");
        for(int i=0; i<m; i++) {
            box.add(Integer.parseInt(sb[i]));
            if (box.get(i) > crane[n-1]) { // 모든 박스를 배로 옮길 수 없으면 -1 출력
                System.out.println(-1);
                return;
            }
        }
        Collections.sort(box); // 오름차순 정렬
        
        int time = 0;
        while (box.size() > 0) {
            for(int i=n-1; i>=0; i--) {
                for(int j=box.size()-1; j>=0; j--) {
                    if (crane[i] >= box.get(j)) {
                        box.remove(j);
                        break;
                    }
                }
            }
            time++;
        }
        System.out.println(time);
	}
}