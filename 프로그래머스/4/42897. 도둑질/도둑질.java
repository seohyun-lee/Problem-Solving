class Solution {
    static int rob(int[] money, int start, int end){
        int[] dp = new int[money.length];
        dp[start]=money[start];
        dp[start+1]=Math.max(dp[start], money[start+1]);
        for(int i=start+2; i<=end; i++){
            dp[i]=Math.max(dp[i-2]+money[i], dp[i-1]); // 지금 것 선택 OR 미선택
        }
        return dp[end];
    }
    public int solution(int[] money) {
        int answer = 0;
        int n = money.length;
        return Math.max(rob(money, 0, n-2), rob(money, 1, n-1));
    }
}
