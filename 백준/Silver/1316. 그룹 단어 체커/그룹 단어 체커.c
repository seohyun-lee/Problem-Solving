#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
int main()
{
	int n, cnt=0;
	scanf("%d\n",&n);
	for (int i = 0; i < n; i++) {
		char pw = '0', w;
		int result = 0;
		int a[26] = { 0 };
		while (1)
		{
			scanf("%c", &w);
			if (w == '\n')
				break;
			if (w != pw && a[w - 97] == 1)
				result = 1;
			if (w != pw)
				a[w - 97] = 1;
			pw = w;
		}
		if (result == 0)
			cnt++;
	}
	printf("%d",cnt);
}