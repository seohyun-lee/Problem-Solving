class Solution {
    public static int gcd(int a, int b){
        if(a%b==0) return b;
        System.out.println(a+" "+b);
        return gcd(b, a%b);
    }
    public int[] solution(int n, int m) {
        int a;
        if(n>=m) a = gcd(n, m);
        else a = gcd(m, n);
        return new int[]{a, n*m/a};
    }
}