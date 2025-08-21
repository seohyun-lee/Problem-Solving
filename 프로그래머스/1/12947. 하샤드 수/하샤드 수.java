class Solution {
    public boolean solution(int x) {
        char[] arr = String.valueOf(x).toCharArray();
        int sum=0;
        for(char c : arr) {
            sum += c-'0';
        }
        return x%sum==0;
    }
}