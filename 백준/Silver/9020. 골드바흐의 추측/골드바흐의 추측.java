import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[10001];
        Arrays.fill(isPrime, true);
        for (int i=2; i*i<=10000; i++) {
            if (isPrime[i]) {
                for (int j=i*i; j<=10000; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            for (int i = n/2; i>=2; i--) {
                int a = i;
                int b = n-i;
                if (isPrime[a] && isPrime[b]) {
                    System.out.println(a + " " + b);
                    break;
                }
            }
        }
    }
}
