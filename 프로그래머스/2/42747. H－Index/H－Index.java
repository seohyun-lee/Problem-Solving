import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i=0; i<citations.length; i++) {
            int min = Math.min(citations[i], citations.length-i);
            if (min>=answer)
                answer=min;
            else
                break;
        }
        return answer;
    }
}
