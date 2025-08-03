import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n != -1) {
            int sum = 0;
            boolean flag = false;
            System.out.print(n+" ");
            StringBuilder sb = new StringBuilder();
            sb.append("=");
            for(int i=1; i<=n; i++) {
                if (n % i == 0) {
                    if (sum == n) {
                        if (i == n)
                            flag = true;
                        else
                            flag = false;
                        break;
                    }
                    sum += i;
                    if (sum < n)
                        sb.append(" "+i+" +");
                    else if (sum == n){
                        sb.append(" "+i);
                        flag = true;
                    }
                }
            }
            if (flag == true)
                System.out.println(sb.toString());
            else 
                System.out.println("is NOT perfect.");
            n = Integer.parseInt(br.readLine());
        }
    }
}
