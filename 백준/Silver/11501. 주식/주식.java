import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
		    int n = Integer.parseInt(br.readLine());
		    int[] stock = new int[n];
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    for(int i=0; i<n; i++) {
		        stock[i] = Integer.parseInt(st.nextToken());
		    }
		    long profit = 0;
		    int max = stock[n-1];
		    for(int i=n-1; i>=0; i--) {
		        if (stock[i] > max)
		            max = stock[i];
		        else
		            profit += (max-stock[i]);
		    }
		    sb.append(profit).append('\n');
		}
		System.out.println(sb);
	}
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}