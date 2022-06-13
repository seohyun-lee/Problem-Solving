#include<stdio.h>
int main()
{
	long long int N;
	int i, count=1;
	scanf("%lld", &N);
	for (i = 0 ;; i++)
	{
		if (N <= count + 6*i)
			break;
		count+=6*i;
	}
	printf("%lld", i+1);
}