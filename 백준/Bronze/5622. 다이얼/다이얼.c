#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
int main() {
	int time = 0, i = 0;
	while (1)
	{
		char c;
		scanf("%c", &c);
		if (c == '\n')
			break;
		int a = (c - 65) / 3;
		time = time + a + 3;
		if (c == 'S' || c == 'V' || c == 'Y' || c == 'Z')
			time--;
	}
	printf("%d", time);
	return 0;
}