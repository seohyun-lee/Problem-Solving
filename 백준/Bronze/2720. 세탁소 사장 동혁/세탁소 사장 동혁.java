import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    for(int i=0; i<t; i++) {
	        int c = Integer.parseInt(br.readLine());
	        int qc=0, dc=0, nc=0, pc=0;
	        qc = c/25;
	        c %= 25;
	        dc = c/10;
	        c %= 10;
	        nc = c/5;
	        c %= 5;
	        pc = c/1;
	        System.out.println(qc+" "+dc+" "+nc+" "+pc);
	    }
	}
}