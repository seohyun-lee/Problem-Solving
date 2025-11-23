import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int N, M, K, X;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B); 
        }

        int[] dist = new int[N+1];
        Arrays.fill(dist, -1); // 방문 안 한 상태 초기화
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(X);
        dist[X] = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : graph[cur]){
                if(dist[next] == -1){ // 첫 방문일 때만
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }

        boolean printed = false;
        for(int i=1; i<=N; i++){
            if(dist[i] == K){
                System.out.println(i);
                printed = true;
            }
        }
        if(!printed) System.out.println(-1);
    }
}
