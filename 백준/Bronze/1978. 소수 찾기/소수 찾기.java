import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int count=0;
        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(s[i]);
            if (x < 2) continue;
            boolean flag = true;
            for(int j=2; j*j<=x; j++) {
                if (x%j==0) {
                    flag = false;
                    break;
                }
            }
            if(flag) count++;
        }
        System.out.println(count);
    }
}
