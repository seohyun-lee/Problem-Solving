class Solution {
    public int solution(int[][] dots) {
        if (isParallel(dots[0], dots[1], dots[2], dots[3]) ||
            isParallel(dots[0], dots[2], dots[1], dots[3]) ||
            isParallel(dots[0], dots[3], dots[1], dots[2])) {
            return 1;
        }
        return 0;
    }
    private boolean isParallel(int[] a, int[] b, int[] c, int[] d) {
        float x1 = b[0]-a[0];
        float x2 = d[0]-c[0];
        float y1 = b[1]-a[1];
        float y2 = d[1]-c[1];
        return (y1 * x2) == (y2 * x1);
    }
}