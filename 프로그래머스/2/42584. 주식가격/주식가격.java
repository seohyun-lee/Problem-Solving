import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stk = new Stack<>(); // 인덱스를 저장
        for(int i=0; i<n; i++){
            while(!stk.isEmpty() && prices[stk.peek()] > prices[i]){ // 큰수 등장
                int prev=stk.pop(); // prev가
                answer[prev]=i-prev; // i-prev만큼 버팀
            }
            stk.push(i);
        }
        while (!stk.isEmpty()){
            int prev=stk.pop();
            answer[prev]=n-1-prev; // 거리만큼 버팀
        }
        return answer;
    }
}