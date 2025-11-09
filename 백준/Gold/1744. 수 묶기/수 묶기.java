import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder()); // 양수는 내림차순 정렬
        PriorityQueue<Integer> minus = new PriorityQueue<>(); // 음수는 오름차순 정렬
        int oneCount = 0;
        int zeroCount = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            if (k > 1) plus.add(k);
            else if (k == 1) oneCount++;
            else if (k == 0) zeroCount++;
            else minus.add(k);
        }
        
        // 양수 처리 (내림차순)
        while (plus.size() > 1) {
            int a = plus.poll();
            int b = plus.poll();
            result += a * b;
        }
        if (!plus.isEmpty())
            result += plus.poll();

        // 음수 처리 (오름차순)
        while (minus.size() > 1) {
            int a = minus.poll();
            int b = minus.poll();
            result += a * b;
        }
        if (!minus.isEmpty()) { // 음수 하나 남은 경우
            if (zeroCount == 0)
                result += minus.poll(); // 0 없으면 더함
        }

        // 1은 전부 더하기
        result += oneCount;

        System.out.println(result);
    }
}
