class Solution {
    public int solution(int left, int right) {
        int[] dp = new int[1001];
        dp[0]=0; dp[1]=1;
        for(int j=2; j<=right; j++) {
            dp[j] += 2;
            for(int k=j*2; k<=right; k+=j) {
                dp[k]++;
            }
        }
        int answer = 0;
        for(int i=left; i<=right; i++) {
            answer = dp[i]%2==0 ? answer+i : answer-i;
        }
        return answer;
    }
}