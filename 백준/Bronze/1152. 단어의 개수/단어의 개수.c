#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
int main()
{
	char str[1000000] = { 0, };
	int cnt = 0;
	int i = 0;
	while (1) {
		char c;
		scanf("%c", &c);
		str[i]=c;
		if (i == 0 && str[0] == ' ')
			continue;
		if (str[i] == '\n' && str[i - 1] == ' ')
		{
			cnt--;
			break;
		}
		if (str[i] == '\n')
			break;
		if (i == 0)
			cnt = 1;
		if (str[i] == ' ')
			cnt++;
		i++;
	}
	printf("%d", cnt);
	return 0;
}