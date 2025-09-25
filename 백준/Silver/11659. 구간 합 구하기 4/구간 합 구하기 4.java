import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] nm = br.readLine().split(" ");
	    int n = Integer.parseInt(nm[0]);
	    int m = Integer.parseInt(nm[1]);
	    String[] nums = br.readLine().split(" ");
	    
	    int[] sum = new int[n+1];
	    sum[0] = 0;
	    for(int i=1; i<=n; i++) {
	        sum[i] = sum[i-1]+Integer.parseInt(nums[i-1]);
	    }
	    for(int i=0; i<m; i++) {
	        String[] input = br.readLine().split(" ");
	        System.out.println(sum[Integer.parseInt(input[1])]-sum[Integer.parseInt(input[0])-1]);
	    }
	}
}