import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            pq.add((long)scoville[i]);
        }
        if(pq.peek()>=K) return 0;
        int cnt=0;
        while(pq.size()>1){
            cnt++;
            long a=pq.poll();
            long b=pq.poll();
            pq.add(a+b*2);
            if(pq.peek()>=K) return cnt;
        }
        return -1;
    }
}