#include<stdio.h>
int main()
{
	int alpha[26] = { 0, };
	char c;
	int max[2] = { 0, 0 };
	while(1){
		scanf("%c", &c);
		if (c == '\n')
			break;
		int a = c;
		if (65 <= a && a < 65 + 26)
			alpha[a - 65]++;
		else if (97 <= a && a < 97 + 26)
			alpha[a - 97]++;
	}
	for (int i = 0; i < 26; i++)
	{
		if (alpha[i] > max[1])
		{
			max[0] = i;
			max[1] = alpha[i];
		}
		else if (alpha[i] == max[1] && alpha[i] > 0)
			max[0] = -2;
	}
	printf("%c", max[0] + 65);
}