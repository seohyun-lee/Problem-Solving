#include<stdio.h>
int a[10001]={0,};
int d(int n){
while(n<=10000){
int k;
k=n+n/1000+n%1000/100+n%100/10+n%10;
a[k]=1;
n=k;
}
}

int main(void){
for(int i=1;i<=10000;i++)
    d(i);
for(int j=1;j<=10000;j++)
    if(a[j]==0) printf("%d\n",j);
}