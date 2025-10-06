import java.io.*;
import java.util.*;


public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] A = new int[n][2];
        for(int i=0; i<n; i++) {
            A[i][0] = i; // 정렬 전 인덱스
            A[i][1] = Integer.parseInt(br.readLine()); // 값
        }
	    Arrays.sort(A, (a, b) -> {
	        if(a[1]!=b[1]) return Integer.compare(a[1], b[1]); // 값 기준 정렬
	        return Integer.compare(a[0], b[0]);
	    });
	    int max=0;
	    for(int i=0; i<n; i++) {
	        if (max < A[i][0]-i) 
	            max = A[i][0]-i;
	    }
	    System.out.println(max+1);
	}
}