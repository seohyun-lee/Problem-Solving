import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int m = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순
            PriorityQueue<Integer> right = new PriorityQueue<>(); // 오름차순
            sb.append((m+1)/2).append('\n'); // 중앙값 개수

            int count = 0; // 중앙값 개수 카운트
            int read = 0;  // 입력으로 읽은 숫자 갯수
            StringTokenizer st = null;
            while (read < m) { // 총 m개를 다 읽을 때까지 반복
                if (st == null || !st.hasMoreTokens()) { // st가 비었으면(null이거나 더 이상 토큰 x) 새 줄을 읽고 다시 토큰화함.
                    st = new StringTokenizer(br.readLine()); // 다음 줄 읽기
                }
                int a = Integer.parseInt(st.nextToken());
                read++;

                // 삽입
                if (left.isEmpty() || left.peek() >= a) left.add(a);
                else right.add(a);

                // 균형 조정
                if (left.size() > right.size() + 1) {
                    right.add(left.poll());
                } else if (left.size() < right.size()) {
                    left.add(right.poll());
                }
                
                // 중앙값을 10개씩 줄바꿈해 출력
                if (read % 2 == 1) {
                    sb.append(left.peek()).append(' ');
                    count++;
                    if (count % 10 == 0) sb.append('\n');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
