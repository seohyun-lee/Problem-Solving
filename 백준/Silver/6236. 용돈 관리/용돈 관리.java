import java.io.*;
import java.util.*;

public class Main
{
    static int[] A = new int[100000];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int lo=1, hi=0;
        for(int i=0; i<n; i++) {
            A[i] = Integer.parseInt(br.readLine());
            lo = Math.max(A[i], lo);
            hi += A[i];
        }
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(check(m, mid)){
                hi=mid-1;
            } else {
                lo=mid+1;
            }
        }
        br.close();
        System.out.println(lo);
    }
    static boolean check(int m, int k){
        int cnt=0, cur=0;
        for(int i=0; i<n; i++) {
            if(A[i]>cur) {cur=k; cur-=A[i]; cnt++;}
            else {cur-=A[i];}
        }
        return cnt<=m;
    }
}