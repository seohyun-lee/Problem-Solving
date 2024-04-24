#include <stdio.h>

int dFib(int n)
{
    if (n==0) return 0;
    if (n==1) return 1;
    int pp = 0;
    int p = 1;
    int current;
    for (int i = 2; i <= n; i++)
    {
    	current = p + pp;
        pp = p;
        p = current;
    }
    return current;
}

int main()
{
    int n;
    scanf("%d", &n);
    printf("%d", dFib(n));
    return 0;
}