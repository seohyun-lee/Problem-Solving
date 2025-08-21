import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] parts = s.substring(2, s.length()-2).split("\\},\\{");
        List<String[]> list = new ArrayList<>();
        for(String part : parts){
            list.add(part.split(","));
        }
        list.sort(Comparator.comparingInt(a->a.length));
        
        int[] answer = new int[list.size()];
        Set<Integer> set = new HashSet<>();
        int idx=0;
        for(int i=0; i<list.size(); i++) {
            String[] str = list.get(i);
            for(int j=0; j<str.length; j++) {
                int a = Integer.valueOf(str[j]).intValue();
                if(set.add(a)) {
                    answer[idx++] = a;
                }
            }
        }
        return answer;
    }
}