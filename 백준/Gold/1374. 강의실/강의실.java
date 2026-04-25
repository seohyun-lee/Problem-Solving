import java.io.*;
import java.util.*;

public class Main {
    static int solution(int N, int[][] lectures) {
        int cnt=1;
        int[] prevEnds = new int[N];
        Arrays.sort(lectures, (a, b)->{
            if(a[1]==b[1]) return Integer.compare(a[2], b[2]);
            return Integer.compare(a[1], b[1]);
        });
        prevEnds[0]=lectures[0][2];
        for(int i=1; i<N; i++) {
            int j=0;
            for(j=0; j<cnt; j++) {
                if(prevEnds[j]<=lectures[i][1]){ // 새 강의 시작 전에 이전 것 끝나야
                    prevEnds[j]=lectures[i][2];
                    break;
                }
            }
            if(j==cnt){
                cnt++;
                prevEnds[cnt-1]=lectures[i][2];
            }
        }
        return cnt;
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