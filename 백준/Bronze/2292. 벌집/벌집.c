#include<stdio.h>
int main()
{
	int N;
	int i, count=1;
	scanf("%d", &N);
	for (i = 0 ;; i++)
	{
		if (N <= count + 6*i)
			break;
		count+=6*i;
	}
	printf("%d", i+1);
}