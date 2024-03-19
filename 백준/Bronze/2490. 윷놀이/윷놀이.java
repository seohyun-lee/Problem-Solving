import java.util.Scanner;

public class Main {
    public static void solution() throws Exception {
        Scanner sc = new Scanner(System.in);
        char[] output = new char[3];
        for (int i=0; i<3; i++) {
            int count = 0;
            for (int j=0; j<4; j++) {
                if (sc.nextInt() == 1)
                    count++;
            }
            switch(count) {
                case 3: // 도
                    output[i] = 'A';
                    break;
                case 2: // 개
                    output[i] = 'B';
                    break;
                case 1: // 걸
                    output[i] = 'C';
                    break;
                case 0: // 윷
                    output[i] = 'D';
                    break;
                case 4: // 모
                    output[i] = 'E';
                    break;
            }
        }
        for (int i=0; i<3; i++) {
            System.out.println(output[i]);
        }
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}