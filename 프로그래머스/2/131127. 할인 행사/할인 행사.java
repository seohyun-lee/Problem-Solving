import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int day=0;
        for(int i=0; i<discount.length-9; i++){
            Map<String, Integer> map = new HashMap<>();
            // discount[i] 부터 discount[i+9]까지 want, number 일치 체크
            for(int j=0; j<10; j++) {
                map.put(discount[i+j], map.getOrDefault(discount[i+j], 0) + 1);
            }
            boolean flag = true;
            for(int j=0; j<want.length; j++) {
                if (!map.containsKey(want[j]) || map.get(want[j]) != number[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                day++;
            }
        }
        return day;
    }
}