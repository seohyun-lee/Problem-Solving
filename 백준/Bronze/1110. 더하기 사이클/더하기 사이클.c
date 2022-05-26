#include<stdio.h>
int main(){
    int n,b,a=0,i=0;
    scanf("%d",&n);
    if(n==0)
    {
        printf("1");
        return 0;
    }
    int k=n;
    while(a!=n){
        if(k<10)
            a=k*11;
        else
        {
            b=k%10+k/10;
            a=(k%10)*10+b%10;
        }
        k=a;
        i++;
    }
    printf("%d",i);
    return 0;
}