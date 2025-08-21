class Solution {
    public long solution(int price, int money, int count) {
        long sum=money;
        for(int i=1; i<=count; i++) {
            sum-=price*i;
        }
        return sum>0? 0: -sum;
    }
}