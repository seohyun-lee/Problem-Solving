class Solution {
    public int[] solution(int brown, int yellow) {
        int a = (brown+4)/2; // x+y
        int b = brown+yellow; // xy
        // x = {(x+y)-(x-y)}/2. (x-y)^2=(x+y)^2-4xy
        int[] answer = {(int)(a+Math.sqrt(a*a-4*b))/2, (int)(a-Math.sqrt(a*a-4*b))/2};
        return answer;
    }
}