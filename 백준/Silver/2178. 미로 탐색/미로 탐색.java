import java.io.*;
import java.util.*;

public class Main
{
    static int n, m;
    static int[][] A;
    static boolean[][] visited;
    static int[] dx={0, 1, 0, -1};
    static int[] dy={1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정점 수
        m = Integer.parseInt(st.nextToken()); // 간선 수
        
        A = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){ 
                A[i][j] = s.charAt(j)-'0';
            }
        }
        bfs(0, 0);
        System.out.println(A[n-1][m-1]);
	}
	
	static void bfs(int i, int j){
	    Queue<int[]> q = new LinkedList<>();
	    q.offer(new int[]{i, j});
	    visited[i][j]=true;
	    
	    while(!q.isEmpty()){
	        int[] now = q.poll();
	        for(int k=0; k<4; k++){
	            int x= now[0]+dx[k];
	            int y= now[1]+dy[k];
	            if(x>=0&&y>=0&&x<n&&y<m){
	                if(A[x][y]!=0&&!visited[x][y]){
	                    visited[x][y]=true;
	                    A[x][y]=A[now[0]][now[1]]+1; // 깊이 업데이트
	                    q.add(new int[]{x, y});
	                }
	            }
	        }
	    }
	}
	
}