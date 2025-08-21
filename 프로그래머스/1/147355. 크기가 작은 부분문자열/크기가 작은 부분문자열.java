class Solution {
    public int solution(String t, String p) {
        Long target = Long.parseLong(p);
        int count=0;
        int n = p.length();
        for(int i=0; i<=t.length()-n; i++) {
            Long v = Long.parseLong(t.substring(i, i+n));
            if (v<=target) count++;
        }
        return count;
    }
}