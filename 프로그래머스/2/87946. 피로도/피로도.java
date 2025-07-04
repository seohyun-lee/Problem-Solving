class Solution {
    int max = 0;
    
    private void goDungeon(int currentFatigue, boolean[] visited, int[][] dungeons, int cnt){
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && currentFatigue >= dungeons[i][0]) {
                visited[i] = true;
                goDungeon(currentFatigue-dungeons[i][1], visited, dungeons, cnt+1);
                visited[i] = false;
            }
        }
        max = Math.max(max, cnt);
    }
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        goDungeon(k, visited, dungeons, 0);
        return max;
    }
}
