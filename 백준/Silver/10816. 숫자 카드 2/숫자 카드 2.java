import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());
        int[] cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine().trim());
        int[][] queries = new int[M][2];
        int[] answer = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            queries[i][0] = Integer.parseInt(st.nextToken());
            queries[i][1] = i;
        }
        
        Arrays.sort(cards);
        Arrays.sort(queries, (a, b)->Integer.compare(a[0], b[0]));
        int cidx=0;
        int qidx=0; 
        while (qidx<M) {
            int q = queries[qidx][0];
            while(cidx<N&&cards[cidx]<q) cidx++; // 작은 범위 버리기
            int count=0;
            while(cidx<N&&cards[cidx]==q) { // 카드가 몇개인지 카운트
                count++;
                cidx++;
            }
            while(qidx<M&&queries[qidx][0]==q){ // 쿼리에 카드 숫자가 같은 것들 모두 업데이트해야
                answer[queries[qidx][1]] = count;
                qidx++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            sb.append(answer[i]);
            if(i<M-1) sb.append(' ');
        }
        System.out.println(sb);
    }
}