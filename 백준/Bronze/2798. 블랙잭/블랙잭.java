import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        String[] s = br.readLine().split(" ");
        int[] cards = new int[n];
        for(int i=0; i<n; i++) {
            cards[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(cards);
        int answer = 0;
        for(int i=0; i<n-2; i++) {
            for(int j=i+1; j<n-1; j++) {
                for(int k=j+1; k<n; k++) {
                    int sum = cards[i]+cards[j]+cards[k];
                    if (sum > m) break;
                    if (m-answer > m-sum) {
                        answer = sum;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
