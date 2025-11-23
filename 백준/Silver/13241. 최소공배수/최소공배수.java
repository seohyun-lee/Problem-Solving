import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int ans=1;
        if(A>B) ans=find(A, B);
        else ans=find(B, A);
        System.out.println((long)A*B/ans);
    }
    static int find(int a, int b){
        if (a % b == 0) return b;
        return find(b, a%b);
    }
}

