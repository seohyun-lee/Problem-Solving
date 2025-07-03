class Solution {
    public long solution(int n) {
        n++;
        int[] d = {0, 1, 1};
        for (int i=1; i<=n; i++) {
            d[(i+2)%3] = (d[i%3] + d[(i+1)%3]) % 1234567;
        }
        return d[n%3];
    }
}