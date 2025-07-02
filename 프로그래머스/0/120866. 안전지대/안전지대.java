class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int[] dx = {-1, 0, 1};
        int[] dy = {-1, 0, 1};
        int n = board[0].length;
        boolean[][] mineArea = new boolean[n+2][n+2];
        for (int i=0; i<n*n; i++) {
            if (board[i/n][i%n]==1) {
                for (int j=0; j<3; j++) {
                    for (int k=0; k<3; k++) {
                        mineArea[i/n+1+dx[j]][i%n+1+dy[k]]=true;
                    }
                }
            }
        }
        for (int i=0; i<n*n; i++) {
            if (mineArea[i/n+1][i%n+1]==false) answer++;
        }   
        return answer;
    }
}