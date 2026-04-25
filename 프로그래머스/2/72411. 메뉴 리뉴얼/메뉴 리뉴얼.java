import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    
    void comb(char[] arr, int start, int dep, int tgt, StringBuilder sb){
        if(dep==tgt){
            String key=sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1); // key 삽입
            return;
        }
        for(int i=start; i<arr.length; i++){
            sb.append(arr[i]); // 뒤에 붙이기
            comb(arr, i+1, dep+1, tgt, sb);
            sb.deleteCharAt(sb.length()-1); // 뒤에 제거하기
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        for(String order : orders){
            char[] arr = order.toCharArray(); // String->char[]
            Arrays.sort(arr); // 오름차순
            for(int len : course){
                if(arr.length>=len) {
                    comb(arr, 0, 0, len, new StringBuilder());
                }
            }
        }
        List<String> answer = new ArrayList<>();
        for(int len : course){
            int max=0;
            for(String key : map.keySet()){
                if(key.length() == len){
                    max=Math.max(max, map.get(key));
                }
            }
            if(max<2) continue;
            for(String key : map.keySet()){
                if(key.length() == len&& map.get(key)== max){
                    answer.add(key);
                }
            }
        }
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
}