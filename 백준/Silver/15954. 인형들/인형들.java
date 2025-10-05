import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] p;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        p = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        double min=Double.MAX_VALUE;
        for(int cnt=k; cnt<=n; cnt++){
            for(int i=0; i<=n-cnt; i++){
                double m=0;
                double sd=0;
                for(int j=i; j<i+cnt; j++){
                    m+=p[j];
                }
                m/=cnt;
                for(int j=i; j<i+cnt; j++){
                    sd+=(p[j]-m)*(p[j]-m);
                }
                sd/=cnt;
                sd = Math.sqrt(sd);
                min = Math.min(sd, min);
            }
        }
        System.out.println(min);
    }
}