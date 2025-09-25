import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    int[] A = new int[n];
	    int[] ans = new int[n];
	    Stack<Integer> stk = new Stack<>();
	    StringTokenizer sb = new StringTokenizer(br.readLine());
	    for(int i=0; i<n; i++) {
	        A[i] = Integer.parseInt(sb.nextToken());
	        ans[i] = -1;
	    }
	    stk.push(0);
	    for(int i=1; i<n; i++) {
	        while(!stk.isEmpty() && A[stk.peek()]<A[i]){
                ans[stk.pop()] = A[i];
	        }
	        stk.push(i);
	    }
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    for(int i=0; i<n; i++) {
	        bw.write(ans[i]+" ");
	    }
	    bw.write("\n");
	    bw.flush();
	}
}