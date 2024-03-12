
import java.util.Scanner;

public class Main {
    public static void solution() throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        for (int i = n - 1; i >= 0; i--) {
            if (k == 0)
                break;
            count += k / coins[i];
            k %= coins[i];
        }
        System.out.print(count);
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}