class Solution {
    public int solution(int hp) {
        int answer = 0;
        while(hp/5>0){
            answer+=(hp/5);
            hp%=5;
        }
        while(hp/3>0){
            answer+=(hp/3);
            hp%=3;
        }
        while(hp>0){
            answer++;
            hp--;
        }
        return answer;
    }
}