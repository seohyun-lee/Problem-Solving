import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    int curr=4;
	    int idx=1;
	    for(int i=1; i<=t; i++) {
	        idx*=2;
	        curr = (idx+1)*(idx+1);
	    }
	    System.out.println(curr);
	}
}