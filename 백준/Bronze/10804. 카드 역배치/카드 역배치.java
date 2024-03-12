import java.util.Scanner;

public class Main {
    public static void swap(int[] cards, int a, int b) {
        for (int i = 0; i < (b - a + 1) / 2; i++) {
            int temp = cards[a + i];
            cards[a + i] = cards[b - i];
            cards[b - i] = temp;
        }
    }

    public static void solution() throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] cards = new int[20];
        for (int i = 0; i < 20; i++) {
            cards[i] = i + 1;
        }
        for (int i = 0; i < 10; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            swap(cards, a, b);
        }
        for (int i = 0; i < 20; i++) {
            System.out.print(cards[i]);
            if (i != 19)
                System.out.print(" ");
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}