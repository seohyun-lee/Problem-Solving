
import java.util.Scanner;

public class Main {
    public static void solution() throws Exception {
        Scanner sc = new Scanner(System.in);
        int[][] paper = new int[100][100];
        int count = sc.nextInt();
        int area = 0;
        for (int i=0; i<count; i++) {
            int left = sc.nextInt();
            int down = sc.nextInt();
            for (int j=0; j<10; j++){
                for (int k=0; k<10; k++) {
                    if (paper[left + k][down + j] == 0) {
                        area++;
                        paper[left + k][down + j] = 1;
                    }
                }
            }
        }
        System.out.print(area);
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}