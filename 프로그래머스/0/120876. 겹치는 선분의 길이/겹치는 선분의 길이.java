class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int x1 = lines[0][0], y1 = lines[0][1];
        int x2 = lines[1][0], y2 = lines[1][1];
        int x3 = lines[2][0], y3 = lines[2][1];
        int lineCount=0;
        for (int i=-100; i<=100; i++){
            if (i==x1) lineCount++;
            if (i==x2) lineCount++;
            if (i==x3) lineCount++;
            if (i==y1) lineCount--;
            if (i==y2) lineCount--;
            if (i==y3) lineCount--;
            if (lineCount >= 2) answer++;
        }
        return answer;
    }
}