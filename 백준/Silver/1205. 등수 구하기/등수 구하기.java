import java.io.*;
import java.util.*;

public class Main {
    static int N, S, P;
    static List<Integer> scores;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        scores = new ArrayList<>();
        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                scores.add(Integer.parseInt(st.nextToken()));
            }
        }
        int rank = getRank();
        System.out.println(rank);
    }

    static int getRank() {
        scores.add(S);
        scores.sort(Collections.reverseOrder());
        int rank = scores.indexOf(S)+1;
        //만약, 랭킹 리스트가 꽉 차있을 때, 새 점수가 이전 점수보다 더 좋을 때만 점수가 바뀐다.
        if (rank > P || (scores.size() > P && scores.get(P) == S))
            return -1;
        return rank;
    }
}
