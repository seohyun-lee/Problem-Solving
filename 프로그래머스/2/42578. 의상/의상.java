import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 1;
        for (String[] s : clothes) {
            if (map.containsKey(s[1])) {
                answer /= (map.get(s[1])+1);
            }
            int newCnt = map.getOrDefault(s[1], 0)+1;
            map.put(s[1], newCnt);
            answer *= (newCnt+1);
        }
        return answer-1;
    }
}