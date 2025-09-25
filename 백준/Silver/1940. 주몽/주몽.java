import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    int m = Integer.parseInt(br.readLine());
	    int[] A = new int[n];
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    for(int i=0; i<n; i++) {
	        A[i] = Integer.parseInt(st.nextToken());
	    }
	    Arrays.sort(A);
	    int count = 0;
	    int i=0;
	    int j=n-1;
	    while(i<j) {
	        if(A[i] + A[j] < m)
	            i++;
	        else if (A[i] + A[j] > m)
	            j--;
	        else {
	            count++;
	            i++;
	            j--;
	        }
	    }
	    System.out.println(count);
	    br.close();
	}
}