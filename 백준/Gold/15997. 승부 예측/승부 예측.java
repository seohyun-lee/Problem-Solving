import java.io.*;
import java.util.*;

public class Main {
    static String[] teams = new String[4];
    static double[] prob = new double[4];
    static Match[] matches = new Match[6];

    static class Match {
        int A, B;
        double W, D, L;
        Match(int A, int B, double W, double D, double L) {
            this.A = A;
            this.B = B;
            this.W = W;
            this.D = D;
            this.L = L;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<4; i++) {
            teams[i] = st.nextToken();
        }
        
        for (int i=0; i<6; i++) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();
            int a = Arrays.asList(teams).indexOf(A); // 이렇게 A가 값일 때의 인덱스를 구하기!!
            int b = Arrays.asList(teams).indexOf(B);
            double W = Double.parseDouble(st.nextToken());
            double D = Double.parseDouble(st.nextToken());
            double L = Double.parseDouble(st.nextToken());
            matches[i] = new Match(a, b, W, D, L);
        }

        dfs(0, new double[4], 1.0);

        for(int i=0; i<4; i++){
            System.out.printf("%.10f%n", prob[i]);
        }
    }

    // p: 현재 시나리오(가지)가 발생할 확률을 누적하는 확률값
    static void dfs(int idx, double[] score, double p) {
        if(idx==6){
            distribute(score, p);
            return;
        }
        
        Match m = matches[idx];
        double[] next;

        // A승
        next = score.clone();
        next[m.A] += 3;
        dfs(idx + 1, next, p * m.W);

        // 무승부
        next = score.clone();
        next[m.A] += 1;
        next[m.B] += 1;
        dfs(idx + 1, next, p * m.D);

        // B승
        next = score.clone();
        next[m.B] += 3;
        dfs(idx + 1, next, p * m.L);
    }

    static void distribute(double[] score, double p) {
        double[] sorted = score.clone();
        Arrays.sort(sorted); // 오름차순 정렬
    
        double firstScore = sorted[3];
        double secondScore = sorted[2];
    
        // 1등/2등 개수 세기
        int cnt1 = 0, cnt2 = 0;
        for (double s : score) {
            if (s == firstScore) cnt1++;
            else if (s == secondScore) cnt2++;
        }
    
        // 1등과 2등 확률 계산
        double firstProb = (cnt1 >= 2) ? 2.0 / cnt1 : 1.0;
        double secondProb = (cnt1 >= 2) ? 0.0 : 1.0 / cnt2;
    
        // 각 팀의 확률 누적
        for (int i = 0; i < 4; i++) {
            if (score[i] == firstScore)
                prob[i] += p * firstProb;
            else if (score[i] == secondScore)
                prob[i] += p * secondProb;
        }
    }
}
