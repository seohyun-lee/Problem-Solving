#include  <stdio.h>

int main(void)
{
    int min,max,c=1;
    for(int i=1;i<=9;i++){
        int a;
        scanf("%d",&a);
        if(i==1){
            max=a;
            min=a;
        }
        else{
            if(max<a){
                max=a;
                c=i;
            }
        }
    }
    printf("%d\n%d",max, c);
    return 0;
}