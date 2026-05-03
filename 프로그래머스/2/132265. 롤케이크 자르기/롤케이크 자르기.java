import java.util.*;

class Solution {
    static int cnt=0;
    public int solution(int[] topping) {
        int n=topping.length;
        int start=n/2;
        search(topping);
        return cnt;
    }
    void search(int[] topping){
        int mid=0;
        Set<Integer> left = new HashSet<>();
        Set<Integer> right = new HashSet<>(); // 처음에 오른쪽이 길다
        HashMap<Integer, Integer> rightMap = new HashMap<>();
        for(int i=0; i<topping.length; i++){
            right.add(topping[i]);
            rightMap.merge(topping[i], 1, Integer::sum);
        }
        while(mid>=0&&mid<topping.length-1){
            if(rightMap.getOrDefault(topping[mid], 0)>1){
                rightMap.put(topping[mid], rightMap.get(topping[mid])-1);
            } else { 
                right.remove(topping[mid]);
            }
            left.add(topping[mid]);
            if(left.size()<right.size()) {
                mid++;
            } else if(left.size()>right.size()){
                break;
            } else {
                cnt++;
                mid++;
            }
        }
    }
}