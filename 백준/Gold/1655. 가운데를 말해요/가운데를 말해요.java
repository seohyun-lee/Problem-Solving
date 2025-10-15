import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    PriorityQueue<Integer> smalls = new PriorityQueue<>(Collections.reverseOrder());
	    PriorityQueue<Integer> bigs = new PriorityQueue<>();
	    for(int i=0; i<n; i++){
	        int input = Integer.parseInt(br.readLine());
	        // 삽입
            if (smalls.isEmpty() || input <= smalls.peek()) {
                smalls.offer(input);
            } else {
                bigs.offer(input);
            }
            // 균형 조정 
            if (smalls.size() > bigs.size()+1) {
                bigs.offer(smalls.poll());
            } else if (bigs.size() > smalls.size()) {
                smalls.offer(bigs.poll());
            }
            System.out.println(smalls.peek());
	    }
	}
}