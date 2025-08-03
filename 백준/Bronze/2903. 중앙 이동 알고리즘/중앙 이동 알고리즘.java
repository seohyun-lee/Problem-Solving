import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n = 1 << t;
        int curr = (n + 1) * (n + 1);
        System.out.println(curr);
    }
}
