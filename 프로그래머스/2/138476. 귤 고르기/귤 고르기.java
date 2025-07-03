import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        int cnt = 0;
        for(int i : keySet) {
            if (k <= 0)
                break;
            k -= map.get(i);
            cnt++;
        }
        return cnt;
    }
}