import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] houses = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());	
		for(int i=0; i<n; i++) {;
			houses[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(houses);
		System.out.println(houses[(n-1)/2]);
	}
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}