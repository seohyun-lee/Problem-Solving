import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int n = Integer.parseInt(input[0]);
	    int b = Integer.parseInt(input[1]);
	    StringBuilder sb = new StringBuilder();
	    while(n > 0) {
	        int a = n % b;
	        if (a >= 0 && a <= 9) {
	            sb.append(a);
	        } else {
	            sb.append((char)('A' + a - 10));
	        }
	        n /= b;
	    }
	    System.out.println(sb.reverse().toString());
	}
}