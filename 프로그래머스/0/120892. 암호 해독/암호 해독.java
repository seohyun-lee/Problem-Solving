class Solution {
    public String solution(String cipher, int code) {
        StringBuffer sb = new StringBuffer();
        for(int i=code-1; i<cipher.length(); i+=code) {
            sb.append(cipher.charAt(i));
        }
        return sb.toString();
    }
}