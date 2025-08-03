import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int count=0;
        for(int i=1; i<=n; i++) {
            if (n%i==0) {
                count++;
                if (count==m) {
                    System.out.println(i);
                    return;
                }
            }
        }
        System.out.println(0);
    }
}
