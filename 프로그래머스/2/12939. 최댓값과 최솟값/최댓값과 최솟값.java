import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] srr = s.split(" ");
        int n = srr.length;
        int[] irr = new int[n];
        for (int i=0; i<n; i++) {
            irr[i] = Integer.parseInt(srr[i]);
        }
        Arrays.sort(irr);
        return irr[0] + " " + irr[irr.length-1];
    }
}