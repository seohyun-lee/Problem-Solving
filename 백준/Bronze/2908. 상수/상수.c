#include<stdio.h>
int main()
{
	int a[3], b[3], i;
	char num;
	for (i = 2; i >= 0; i--)
		scanf("%1d", &a[i]);
	for (i = 2; i >= 0; i--){
		scanf("%1d", &b[i]);
		if (100 * a[0] + 10 * a[1] + a[2] > 100 * b[0] + 10 * b[1] + b[2])
			num = 'a';
		else
			num = 'b';
	}
	if(num == 'a')
		printf("%d%d%d", a[0], a[1], a[2]);
	else
		printf("%d%d%d", b[0], b[1], b[2]);
	return 0;
}