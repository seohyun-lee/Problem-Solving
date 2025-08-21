class Solution {
    public int solution(int price) {
        if(price>=500000) price*=0.80;
        else if (price>=300000) price*=0.9;
        else if (price>=100000) price*=0.95;
        return price;
    }
}