import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int max=0, cnt=0;
        for(int i=0; i<progresses.length; i++) {
            int day = (int) Math.ceil((double)(100-progresses[i])/speeds[i]);
            if(i == 0 || day > max) {
                if (i != 0) answer.add(cnt);
                max = day;
                cnt = 1;
            } else {
                cnt++;
            }
        }
        answer.add(cnt);
        return answer.stream().mapToInt(i -> i).toArray();
    }
}