#include  <stdio.h>
int main(void)
{
    int c, max=0, sum=0;
    scanf("%d",&c);
    for(int i=0;i<c;i++)
    {
        int x;
        scanf("%d",&x);
        if(x>max)
            max=x;
        sum+=x;
    }
    printf("%f",(float)sum/max/c*100);
}