import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        List<String> list = new ArrayList<>();
        int index=0, turn=1;
        while (index < words.length) {
            for (int i=1; i<=n; i++) {
                if ((list.contains(words[index])) || (index != 0 && (words[index-1].charAt(words[index-1].length()-1) != words[index].charAt(0)))) {
                    return new int[]{i, turn};
                }
                list.add(words[index++]);
            }
            turn++;
        }
        return new int[]{0, 0};
    }
}