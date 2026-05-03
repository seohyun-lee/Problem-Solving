import java.util.*;

class Solution {
    int cnt=0;
    char[] c = new char[]{'A', 'E', 'I', 'O', 'U'};
    int n=5;
    int answer=0;
    public int solution(String word) {
        for(int i=0; i<n; i++){
            dfs(word, ""+c[i], 1);
            if(answer!=0) break;
        }
        return answer;
    }
    void dfs(String word, String str, int len){
        cnt++;
        if(word.equals(str)){
            answer=cnt;
            return;
        }
        for(int i=0; i<n; i++){
            if(answer!=0) return;
            if(len<n) dfs(word, str+c[i], len+1);
        }
    }
}