import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cmd = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> {
                int absA = Math.abs(a);
                int absB = Math.abs(b);
                if (absA == absB) return Integer.compare(a, b);
                else return Integer.compare(absA, absB);
            }
        );
        
        for(int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.offer(x);
            }
        }
	}
}