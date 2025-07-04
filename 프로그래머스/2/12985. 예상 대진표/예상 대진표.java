class Solution
{
    public int solution(int n, int a, int b)
    {
        for (int i=1; ; i++) {
            if ((a == b-1 || a-1 == b) && (a+1)/2==(b+1)/2) {
                return i;
            }
            n /= 2;
            a = (a+1)/2;
            b = (b+1)/2;
        }
    }
}