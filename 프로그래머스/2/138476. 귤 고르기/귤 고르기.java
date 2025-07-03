import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : tangerine) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i)+1);
            } else {
                map.put(i, 1);
            }
        }
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        int cnt = 0;
        for(int i : keySet) {
            if (k > 0) {
                if (map.get(i) <= k)
                    k -= map.get(i);
                else
                    k = 0;
                cnt++;
            }
        }
        return cnt;
    }
}