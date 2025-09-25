import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    int[] A = new int[n];
	    for(int i=0; i<n; i++) {
	        A[i] = Integer.parseInt(br.readLine());
	    }
	    
	    Stack<Integer> stk = new Stack<>();
	    StringBuffer sb = new StringBuffer();
	    int num=1;
	    boolean result=true;
	    
	    for(int i=0; i<A.length; i++) {
	        int ai = A[i];
	        if(num<=ai) {
    	        while(num<=ai){
        	        stk.push(num);
    	            sb.append("+\n");
        	        num++;
    	        }
    	        stk.pop();
    	        sb.append("-\n");
	        } else {
	            int top = stk.pop();
	            if(top<=ai) {
    	            sb.append("-\n");
	            } else {
	                System.out.println("NO");
	                result=false;
	                break;
	            }
	        }
	    }
	    if(result) System.out.println(sb.toString());
	    br.close();
	}
}