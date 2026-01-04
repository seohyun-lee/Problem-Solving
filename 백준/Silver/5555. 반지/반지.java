import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            String ring = br.readLine();
            String doubled = ring + ring;
            if (doubled.contains(target)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
