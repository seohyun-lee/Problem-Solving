class Solution {
    boolean solution(String s) {
        String s1 = s.replaceAll("[^pP]", "");
        String s2 = s.replaceAll("[^yY]", "");
        return s1.length() == s2.length();
    }
}