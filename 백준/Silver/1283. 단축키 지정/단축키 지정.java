import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        boolean[] alpha = new boolean[26];
        for (int i=0; i<n; i++) {
            String str = br.readLine();
            String[] splitstr = str.split(" ");
            StringBuilder newString = new StringBuilder();
            boolean flag = false;
            for(int j=0; j<splitstr.length; j++){
                char c = splitstr[j].charAt(0);
                int idx = Character.toUpperCase(c) - 'A';
                if(flag == false && (idx >= 0 && idx < 26) && alpha[idx] == false) {
                    alpha[idx] = true;
                    flag = true;
                    newString.append('[').append(c).append(']').append(splitstr[j], 1, splitstr[j].length());
                } else {
                    newString.append(splitstr[j]);
                }
                if (j != splitstr.length-1)
                    newString.append(' ');
            }
            if (flag == false) {
                newString = new StringBuilder();
                for(int k=0; k<str.length(); k++){
                    char c = str.charAt(k);
                    int idx = Character.toUpperCase(c) - 'A';
                    if(flag == false && (idx >= 0 && idx < 26) && alpha[idx] == false) {
                        alpha[idx] = true;
                        flag = true;
                        newString.append('[').append(c).append(']').append(str, k+1, str.length());
                        break;
                    } else {
                        newString.append(c);
                    }
                }
            }
            sb.append(newString).append('\n');
        }
        System.out.println(sb);
    }
    
	public static void main(String[] args) throws Exception {
	    new Main().solution();
	}
}