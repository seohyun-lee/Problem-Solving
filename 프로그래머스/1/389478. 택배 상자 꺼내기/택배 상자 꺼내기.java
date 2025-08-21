class Solution {
    public int solution(int n, int w, int num) {
        int maxRow = (n-1)/w; // 0~4, 4
        int targetRow = (num-1)/w;
        int maxColIdx = maxRow%2==0 ? (n-1)%w : w-1 - (n-1)%w;
        int targetColIdx = targetRow%2==0 ? (num-1)%w : w-1 - (num-1)%w;
        if (maxRow%2==0 && targetColIdx <= maxColIdx || maxRow%2==1 && targetColIdx >= maxColIdx)
            return maxRow - targetRow + 1;
        return maxRow - 1 - targetRow + 1;
    }
}