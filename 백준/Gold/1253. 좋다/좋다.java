import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    int[] A = new int[n];
	    int count = 0;
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    for(int i=0; i<n; i++) {
	        A[i] = Integer.parseInt(st.nextToken());
	    }
	    Arrays.sort(A);
	    
	    for (int m=0; m<n; m++) {
            int i=0;
            int j=n-1;
            while (i<j) {
                if (i==m) { 
                    i++; 
                    continue;
                }
                if (j==m) { 
                    j--; 
                    continue;
                }
        
                if (A[i] + A[j] == A[m]) {
                    count++;
                    break;
                } else if (A[i] + A[j] < A[m]) {
                    i++;
                } else {
                    j--;
                }
            }
        }
	    System.out.println(count);
	    br.close();
	}
}