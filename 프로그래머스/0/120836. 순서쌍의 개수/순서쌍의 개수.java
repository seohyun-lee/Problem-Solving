class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=1; i*i<=n; i++) {
            if((double)n/i == n/i) {
                if (i*i==n) answer++;
                else answer+=2;
            }
        }
        return answer;
    }
}