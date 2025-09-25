import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    String sNum = br.readLine();
	    int sum=0;
	    for(int i=0; i<sNum.length(); i++) {
	        sum += sNum.charAt(i)-'0';
	    }
	    System.out.println(sum);
	}
}
