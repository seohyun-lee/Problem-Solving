class Solution {
    public int solution(int n) {
        int count = 0;
        int left = 1, right = 1, sum = 1;
        while (left <= n) {
            if (sum == n) {
                count++;
                sum -= left++;
            } else if (sum < n) {
                sum += ++right;
            } else {
                sum -= left++;
            }
        }
        return count;
    }
}