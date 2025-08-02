import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int sum=0;
        while(pq.size() >= 2){
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a+b);
            sum += (a+b);
        }
    	System.out.println(sum);
	}
}