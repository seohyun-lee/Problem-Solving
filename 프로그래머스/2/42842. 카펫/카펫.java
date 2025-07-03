class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown+yellow;
        for (int y=3; y<brown; y++) { // a가 세로 길이 후보
            if (total % y != 0) continue;
            int x = total / y;
            if ((x*2 + y*2 - 4 == brown) && (x-2)*(y-2) == yellow) {
                return new int[]{x, y};
            }
        }
        return null;
    }
}