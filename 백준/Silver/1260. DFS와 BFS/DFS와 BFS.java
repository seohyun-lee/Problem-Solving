import java.io.*;
import java.util.*;

public class Main
{
    static int n, m, v;
    static List<Integer>[] A; // 그래프
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정점 수
        m = Integer.parseInt(st.nextToken()); // 간선 수
        v = Integer.parseInt(st.nextToken()); // 탐색 시작 정점 수
        
        A = new ArrayList[n+1]; // n+1 크기의 배열 (A[0]은 사용하지 않음)
        for(int i=1; i<=n; i++){
            A[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            // 양방향
            A[s].add(e);
            A[e].add(s);
        }
        
        // 번호가 작은 것부터 먼저 방문하기 위해 정렬
        for(int i=1; i<=n; i++){
            Collections.sort(A[i]);
        }
        
        visited = new boolean[n+1];
        dfs(v);
        System.out.println();
        
        visited = new boolean[n+1];
        bfs(v);
        System.out.println();
	}
	
	//for문+재귀
	static void dfs(int node){
	    System.out.print(node+" ");
	    visited[node]=true;
	    for(int i : A[node]){
	        if(!visited[i])
	            dfs(i);
	    }
	}
	// while문+for문+큐
	static void bfs(int node){
	    Queue<Integer> q = new LinkedList<>();
	    q.add(node);
	    visited[node]=true;
	    
	    while(!q.isEmpty()){
	        int now = q.poll();
	        System.out.print(now+" ");
	        for(int i : A[now]) {
	            if(!visited[i]){
	                visited[i]=true;
	                q.add(i);
	            }
	        }
	    }
	}
}