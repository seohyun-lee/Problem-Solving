import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int time = 0;
        Deque<String> dq = new ArrayDeque<>();
        for(int i=0; i<cities.length; i++){
            String city = cities[i].toLowerCase();
            if(!dq.contains(city)) {
                dq.addLast(city);
                if(dq.size() > cacheSize)
                    dq.pollFirst();
                time += 5;
            } else {
                dq.remove(city);
                dq.addLast(city);
                time += 1;
            }
        }
        return time;
    }
}