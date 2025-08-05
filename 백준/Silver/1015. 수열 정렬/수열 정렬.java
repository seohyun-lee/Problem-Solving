import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> {
            if(a[0]!=b[0]) return Integer.compare(a[0], b[0]);
            else return Integer.compare(a[1], b[1]);
        });
        
        int[] P = new int[n];
        for(int i=0; i<n; i++) {
            P[arr[i][1]] = i;
        }
        for(int i=0; i<n; i++) {
            if(i!=0) System.out.print(" ");
            System.out.print(P[i]);
        }
    }
}