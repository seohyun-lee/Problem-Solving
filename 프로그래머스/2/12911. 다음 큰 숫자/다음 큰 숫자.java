class Solution {
    public int solution(int n) {
        int i;
        for (i=n+1;i<=1000000;i++) {
            int ncnt = Integer.toBinaryString(n).replace("0", "").length();
            int icnt = Integer.toBinaryString(i).replace("0", "").length();
            if (ncnt==icnt) {
                break;
            }
        }
        return i;
    }
}