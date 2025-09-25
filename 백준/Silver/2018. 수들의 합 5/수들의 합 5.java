import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    int count=1; // n을 바로 뽑는 경우
	    int start=1;
	    int end=1;
	    int sum=1;
	    
	    while(end!=n) {
	        if(sum<=n) {
	            if(sum==n) count++;
	            end++;
	            sum += end;
	        } else {
	            sum -= start;
	            start++;
	        }
	    }
	    System.out.println(count);
	}
}