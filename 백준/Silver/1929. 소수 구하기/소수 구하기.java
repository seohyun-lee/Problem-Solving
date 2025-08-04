import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    boolean[] isPrime = new boolean[m+1];
	    Arrays.fill(isPrime, true);
	    isPrime[0] = isPrime[1] = false;
	    for(int i=2; i*i<=m; i++) {
	        if(isPrime[i]) {
    	        for(int j=i*i; j<=m; j+=i) {
    	            isPrime[j] = false;
    	        }
	        }
	    }
	    for(int i=n; i<=m; i++) {
	        if(isPrime[i]) System.out.println(i);
        }
    }
}
