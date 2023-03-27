class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int x = (a<b)? a:b;
        int y = (a>b)? a:b;
        for(int i = x; i <= y; i++){
            answer+=i;
        }
        return answer;
    }
}