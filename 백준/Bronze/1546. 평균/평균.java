import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    String[] s = br.readLine().split(" ");
	    long sum=0, max=0;
	    for(int i=0; i<n; i++) {
	        int score = Integer.valueOf(s[i]);
			if(max < score)
				max = score;
	        sum += score;
	    }
	    System.out.println(sum*100.0/max/n);
	}
}