class Solution {
    public int[] solution(String s) {
        int cnt1=0, cnt2=0;
        do {
            String tempText = s.replace("0", "");
            cnt2 += (s.length()-tempText.length());
            int a = tempText.length();
            String nextText = "";
            while (a > 0) {
                nextText += a%2;
                a/=2;
            }
            StringBuilder sb = new StringBuilder(nextText);
            s = sb.reverse().toString();
            cnt1++;
        } while (!s.equals("1"));
        int[] answer = new int[]{cnt1, cnt2};
        return answer;
    }
}