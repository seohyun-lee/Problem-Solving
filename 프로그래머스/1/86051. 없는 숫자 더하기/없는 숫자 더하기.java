class Solution {
    public int solution(int[] numbers) {
        boolean[] arr = new boolean[10];
        for(int i=0; i<numbers.length; i++) {
            arr[numbers[i]] = true;
        }
        int sum=0;
        for(int i=0; i<arr.length; i++) {
            if(!arr[i]) sum+=i;
        }
        return sum;
    }
}