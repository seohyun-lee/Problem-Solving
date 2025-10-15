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
            if(smalls.isEmpty()){
	            smalls.add(input);
	        } else if (smalls.size()<=bigs.size()){
	            int s=smalls.poll();
	            if(s>=input) {
	                smalls.add(input);
	                smalls.add(s);
	            } else {
	                int b=bigs.poll();
	                if(b>=input){
    	                smalls.add(input);
    	                smalls.add(s);
	                    bigs.add(b);
	                } else {
    	                smalls.add(s);
    	                smalls.add(b);
	                    bigs.add(input);
	                }
	            }
	        } else {
	            int s=smalls.poll();
	            if(s>=input) {
	                smalls.add(input);
	                bigs.add(s);
	            } else {
	                smalls.add(s);
	                bigs.add(input);
	            }
	        }
	        int sTop = smalls.poll();
	        System.out.println(sTop);
	        smalls.add(sTop);
	    }
	}
}