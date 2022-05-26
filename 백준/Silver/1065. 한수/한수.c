#include<stdio.h>
int cn=0;
int func(int n)
{
    if(n<1000&&n>100)
    {
        if(n%100/10*2==n%10+n%1000/100)
            cn++;
    }
    else if(n<100)
        cn++;
}

int main(void){
    int n;
    scanf("%d",&n);
    for(int i=1;i<=n;i++)
        func(i);
    printf("%d",cn);
}