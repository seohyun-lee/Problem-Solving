class Solution {
    public int[] solution(int n) {
        int[] arr = new int[(n+1)/2];
        for(int i=0; i<(n+1)/2; i++) {
            arr[i]=i*2+1;
        }
        return arr;
    }
}