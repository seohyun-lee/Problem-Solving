import java.io.*;
import java.util.*;

public class Main
{
    static int n, m, target;
    static int[][] map;
    static List<Integer>[] A;
    static boolean[] visited;
    static int[] walk;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정점 수
        m = Integer.parseInt(st.nextToken()); // 간선 수
        
        map = new int[n][m];
        A = new ArrayList[n*m];
        visited = new boolean[n*m];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){ 
                map[i][j] = s.charAt(j)-'0';
                A[i*m+j] = new ArrayList<>();
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){ 
                if(map[i][j]==1){
                    if(j<m-1 && map[i][j+1]==1)
                        A[i*m+j].add(i*m+(j+1));
                    if (i<n-1 && map[i+1][j]==1)
                        A[i*m+j].add((i+1)*m+j);
                    if (j>0 && map[i][j-1]==1)
                        A[i*m+j].add(i*m+(j-1));
                    if (i>0 && map[i-1][j]==1)
                        A[i*m+j].add((i-1)*m+j);
                }
            }
        }
        
        walk = new int[n*m];
        
        // 도착 지점 좌표
        target = n*m-1;
        bfs(0);
        System.out.println(walk[target]);
	}
	static void bfs(int start){
	    Queue<Integer> q = new LinkedList<>();
	    visited[start]=true;
	    q.add(start);
	    walk[start]=1;
	    
	    while(!q.isEmpty()){
	        int now = q.poll();
	        if(now==target){
	            break;
	        }
	        for(int i : A[now]){
	            if(!visited[i]){
	                visited[i] = true;
	                q.add(i);
	                walk[i]=walk[now]+1;
	            }
	        }
	    }
	}
	
}