import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        int index=0, turn=1;
        while (index < words.length) {
            for (int i=1; i<=n; i++) {
                if ((set.contains(words[index])) || (index != 0 && (words[index-1].charAt(words[index-1].length()-1) != words[index].charAt(0)))) {
                    return new int[]{i, turn};
                }
                set.add(words[index++]);
            }
            turn++;
        }
        return new int[]{0, 0};
    }
}