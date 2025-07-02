class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int[] dx = {-1, 0, 1};
        int[] dy = {-1, 0, 1};
        int n = board[0].length;
        for (int i=0; i<n*n; i++) {
            if (board[i/n][i%n]==1) {
                for (int j=0; j<3; j++) {
                    for (int k=0; k<3; k++) {
                        try {
                            if (board[i/n+dx[j]][i%n+dy[k]]==0)
                                board[i/n+dx[j]][i%n+dy[k]]=2;
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
        for (int i=0; i<n*n; i++) {
            if (board[i/n][i%n]==0)
                answer++;
        }   
        return answer;
    }
}