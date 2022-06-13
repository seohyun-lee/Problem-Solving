#include<stdio.h>
int main()
{
	int A, B, C, x;
	scanf("%d %d %d", &A, &B, &C);
	if (B >= C)
	{
		printf("-1");
		return 0;
	}
	x = A / (C - B) + 1;
	printf("%d", x);
	return 0;
}