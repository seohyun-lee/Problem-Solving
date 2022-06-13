#include <stdio.h>
int main()
{
	int N, min=-1;
	int i, j;
	scanf("%d", &N);
	for (i = 0; i<=(N/3); i++)
	{
		for (j = 0; j <= (N/5); j++)
		{
			if (i * 3 + j * 5 == N)
				break;
		}
		if (N == 0)
			break;
		else if (i * 3 + j * 5 == N)
		{
			min = i + j;
			break;
		}
	}
	printf("%d", min);
}