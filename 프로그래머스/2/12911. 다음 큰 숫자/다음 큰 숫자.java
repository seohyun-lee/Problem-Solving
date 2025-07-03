class Solution {
    public int solution(int n) {
        int i;
        for (i=n+1; i<=1000000; i++) {
            if (Integer.bitCount(n) == Integer.bitCount(i)) {
                break;
            }
        }
        return i;
    }
}