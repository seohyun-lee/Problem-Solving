#include<stdio.h>
int main()
{
	int T, H, W, N;
	scanf("%d", &T);
	for (int i = 0; i < T; i++)
	{
		int num, a, b;
		scanf("%d%d%d", &H, &W, &N);
		a = N % H;
		b = N / H;
		if (a == 0)
			a = H;
		else
			b++;
		num = a * 100 + b;
		printf("%d\n", num);
	}
	return 0;
}