import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    int bfs(int[][] maps){
        int m=maps[0].length; // x
        int n=maps.length; // y
        boolean[][] visited=new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 1});
        visited[0][0]=true;
        while(!q.isEmpty()){
            int[] p=q.poll();
            int[] dx={-1,1,0,0};
            int[] dy={0,0,-1,1};
            if(p[0]==m-1&&p[1]==n-1){
                return p[2];
            }
            for(int i=0; i<4; i++){
                int cx=p[0]+dx[i];
                int cy=p[1]+dy[i];
                if(cx<0||cx>=m||cy<0||cy>=n) continue;
                if(maps[cy][cx]==0||visited[cy][cx]) continue;
                q.add(new int[]{cx, cy, p[2]+1});
                visited[cy][cx]=true;
            }
        }
        return -1;
    }
}