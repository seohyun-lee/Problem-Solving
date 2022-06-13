#include<stdio.h>
int main()
{
	int X, count = 1;
	int a[2] = { 1, 1 };
	scanf("%d", &X);
	while (X != count) {
		if (a[0] == 1)
		{
			if (a[1] % 2 == 1)
				a[1]++;
			else
			{
				a[0]++;
				a[1]--;
			}
		}
		else if (a[1] == 1)
		{
			if (a[0] % 2 == 0)
				a[0]++;
			else
			{
				a[0]--;
				a[1]++;
			}
		}
		else if ((a[0] + a[1]) % 2 == 0)
		{
			a[0]--;
			a[1]++;
		}
		else
		{
			a[0]++;
			a[1]--;
		}
		count++;
	}
	printf("%d/%d", a[0], a[1]);
}