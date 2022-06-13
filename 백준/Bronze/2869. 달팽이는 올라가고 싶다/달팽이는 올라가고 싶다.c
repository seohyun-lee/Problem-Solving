#include<stdio.h>
int main()
{
	int A, B, V, day;
	scanf("%d %d %d", &A, &B, &V);
	day = (V - A) / (A - B) + 1;
	if ((V - A) % (A - B) != 0)
		day++;
	printf("%d", day);
}