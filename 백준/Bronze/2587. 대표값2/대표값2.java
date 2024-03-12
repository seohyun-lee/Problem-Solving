
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void solution() throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];
        int average = 0;

        for (int i = 0; i < 5; i++) {
            int n = sc.nextInt();
            average += n;
            numbers[i] = n;
        }
        average /= 5;
        Arrays.sort(numbers);
        System.out.print(average + "\n" + numbers[2]);
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}