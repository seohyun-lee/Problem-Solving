import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        int len = elements.length;
        int[] extended = new int[len*2];
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<len*2; i++) {
            extended[i] = elements[i%len];
        }
        for(int i=0; i<len; i++) { // 갯수
            for (int j=0; j<len; j++) { // 시작점
                int sum = 0;
                for (int k=j; k<=j+i; k++) {
                    sum += extended[k];
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}