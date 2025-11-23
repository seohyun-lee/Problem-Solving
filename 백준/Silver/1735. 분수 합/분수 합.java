import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        long gcd=1;
        if(b>c) gcd=findGcd(b, d);
        else gcd=findGcd(b, d);
        long lcm=b*d/gcd;
        long son=a*(lcm/b)+c*(lcm/d);
        long gcd2 = findGcd(lcm, son);
        System.out.println(son/gcd2+" "+lcm/gcd2);
    }
    static long findGcd(long a, long b){
        if (a % b == 0) return b;
        return findGcd(b, a%b);
    }
}

