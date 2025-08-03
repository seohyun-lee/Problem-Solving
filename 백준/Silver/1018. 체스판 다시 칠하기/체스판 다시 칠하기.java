import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        char[][] board = new char[n][m];
        for (int i=0; i<n; i++) {
            String s = br.readLine();
            for (int j=0; j<m; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        int answer=n*m;
        for (int x=0; x<=n-8; x++) {;
            for (int y=0; y<=m-8; y++) {
                int count1=0, count2=0;
                for (int i=0; i<8; i++) {
                    for (int j=0; j<8; j++) {
                        if (board[x+i][y+j]=='W'){
                            if ((x+i+y+j) % 2 != 0) count1++;
                            else count2++;
                        } else {
                            if ((x+i+y+j) % 2 != 1) count1++;
                            else count2++;
                        }
                    }
                }
                answer = Math.min(answer, Math.min(count1, count2));
            }
        }
        System.out.println(answer);
    }
}