class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        for(int i=0; i<=citations.length; i++) {
            int cnt=0;
            for(int j=0; j<citations.length; j++) {
                if(citations[j]>=i) cnt++;
            }
            if (cnt>=i) answer=i;
        }
        return answer;
    }
}