import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int i = 0;
        Arrays.sort(d);
        for(i=0; i<d.length; i++) {
            if(budget-d[i]>=0) {
                budget-=d[i];
            } else {
                break;
            }
        }
        return i;
    }
}