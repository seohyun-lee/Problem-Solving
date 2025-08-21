class Solution {
    public long solution(long n) {
        int[] arr = new int[10];
        while (n > 0) {
            arr[(int)(n % 10)]++;
            n /= 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            sb.append(Integer.toString(i).repeat(arr[i]));
        }
        return Long.parseLong(sb.toString());
    }
}
