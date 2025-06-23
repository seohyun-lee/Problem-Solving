class Solution {
    private final String[] WORDS = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        int answer = 0;
        for(String s : babbling) {
            if(isValid(s, new boolean[WORDS.length]))
                answer++;
        }
        return answer;
    }
    
    private boolean isValid(String s, boolean[] used) {
        if(s.isEmpty())
            return true;
        for(int i=0; i<WORDS.length; i++){
            if(!used[i] && s.startsWith(WORDS[i])) {
                // 중간 매치 단어를 지울 경우 단어를 빼고 나서 합쳐지는 걸 고려해야 하기 때문에
                // startsWith로 앞에 있는지를 확인하는 것이 편리
                used[i] = true;
                if(isValid(s.substring(WORDS[i].length()), used)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }
}