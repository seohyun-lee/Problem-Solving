import java.io.*;
import java.util.*;

public class Main {
    static int solution(int N, int[][] lectures) {
        // 시작 시간 기준 정렬
        Arrays.sort(lectures, (a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[2], b[2]);
            return Integer.compare(a[1], b[1]);
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 최소 힙
        pq.offer(lectures[0][2]);
        for (int i = 1; i < N; i++) {
            if (pq.peek() <= lectures[i][1]) {
                pq.poll(); // 가장 빨리 끝나는 것을 제거할 수 있는지
            }
            pq.offer(lectures[i][2]);
        }
        return pq.size();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] lectures = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
            lectures[i][2] = Integer.parseInt(st.nextToken());
        }
        int result = solution(N, lectures);
        System.out.println(result);
    }
}