import java.util.Scanner;

public class Main {
    public static void solution() throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] strList = new String[5];
        int maxLength = 0;
        int index = 0;
        for (int i=0; i<5; i++) {
            strList[i] = sc.next();
            if (strList[i].length() > maxLength)
                maxLength = strList[i].length();
        }
        while (index < maxLength) {
            for (int i=0; i<5; i++) {
                if (strList[i].length() > index) {
                    System.out.print(strList[i].charAt(index));
                }
            }
            index++;
        }
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}