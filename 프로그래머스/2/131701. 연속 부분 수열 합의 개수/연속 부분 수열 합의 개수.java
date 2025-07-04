import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[] dp = new int[elements.length]; // 캐시로 사용
        
        for(int len=1; len <= elements.length; len++) {
            for(int i=0; i<elements.length; i++) {
                dp[i] += elements[(i+len-1) % elements.length];
                set.add(dp[i]);
                // dp[i]: 인덱스 i에서 시작하는 길이 len짜리 연속 부분 수열의 합
                // 이전 dp[i] (len-1 길이 합)에 elements[(i+len-1) % elements.length]를 더해 갱신

            }
        }
        return set.size();
        
//         int len = elements.length;
//         Set<Integer> set = new HashSet<>();
        
//         for(int i=0; i<len; i++) { // 갯수
//             for (int j=0; j<len; j++) { // 시작점
//                 int sum = 0;
//                 for (int k=j; k<=j+i; k++) {
//                     sum += elements[k%len];
//                 }
//                 set.add(sum);
//             }
//         }
//         return set.size();
    }
}