import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> q = new LinkedList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int n = priorities.length;
        for(int i=0; i<n; i++){
            q.add(i); // 우선순위가 아니라 인덱스 저장!!
            maxHeap.add(priorities[i]);
        }
        int cnt=0;
        while(!q.isEmpty()){
            int idx=q.peek();
            if(priorities[idx]<maxHeap.peek()) {
                q.add(q.remove());
            } else {
                q.remove();
                maxHeap.poll();
                cnt++;
                if(idx==location) {
                    return cnt;
                }
            }
        }
        return -1;
    }
}