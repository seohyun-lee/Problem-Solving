class Solution {
    public int solution(int n) {
        int[] d = {0, 1, 0};
        for (int i=0; i<=n-2; i++) {
            d[(i+2)%3] = d[(i)%3] + d[(i+1)%3];
            d[(i+2)%3] %= 1234567;
        }
        return d[n%3] % 1234567;
    }
}