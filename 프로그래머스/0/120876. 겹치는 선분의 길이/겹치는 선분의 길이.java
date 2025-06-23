class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int lineCount = 0;
        for (int i=-100; i<=100; i++){
            if (i==lines[0][0]) lineCount++;
            if (i==lines[1][0]) lineCount++;
            if (i==lines[2][0]) lineCount++;
            if (i==lines[0][1]) lineCount--;
            if (i==lines[1][1]) lineCount--;
            if (i==lines[2][1]) lineCount--;
            if (lineCount >= 2) answer++;
        }
        return answer;
    }
}