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
	    int[] rem = new int[m];
	    long ans=0;
	    int sum=0;
	    for(int i=0; i<n; i++) {
	        sum = (sum + Integer.parseInt(nums[i])) % m;
	        if(sum==0) ans++;
	        rem[sum]++;
	    }
	    
	    for(int i=0; i<m; i++) {
	        if(rem[i]>1){
	            ans += (long)rem[i]*(rem[i]-1)/2; // (조합) 2개 뽑는 경우의 수
	        }
	    }
	    System.out.println(ans);
	}
}