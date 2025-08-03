import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for(int i=2; i*i<=n; i++) {
            if(isPrime[i]) {
                for(int j=i*i; j<=n; j+=i) {
                    isPrime[j]=false;
                }
            }
        }
        int sum=0;
        int min=0;
        for(int i=m; i<=n; i++) {
            if (isPrime[i]) {
                sum += i;
                if(min==0) min=i;
            }
        }
        if(sum==0)
            System.out.println(-1);
        else
            System.out.println(sum+"\n"+min);
    }
}
