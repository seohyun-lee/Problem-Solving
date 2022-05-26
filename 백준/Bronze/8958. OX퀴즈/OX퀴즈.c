#include  <stdio.h>
int main(void)
{
    int n;
    scanf("%d ",&n);
    for(int i=0;i<n;i++)
    {
        int score=0;
        char c;
        int con=1;
        do{
            scanf("%c",&c);
            if(c=='O')
            {
                score+=con;
                con++;
            }
            else
                con=1;
        }while(c!='\n');
        printf("%d\n",score);
    }
}