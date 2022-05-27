/*#include<stdio.h>
int main()
{
	char str[1000000] = { 0 };
	int cnt = 0;
	int i = 0;
	while (1) {
		scanf("%c", &str[i]);
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
			cnt++;
		if (str[i] == ' ')
			cnt++;
		i++;
	}
	printf("%d", cnt);
	return 0;
}*/

#include<stdio.h>
int main()
{
	char str[1000000] = { 0 };
	int cnt = 0;
	int i = 0;
	while (1) {
		scanf("%c", &str[i]);
		if (i == 0 && str[i] == ' ')
			continue;
		if (str[i] == '\n')
		{
			if(str[i - 1] == ' ')
                cnt--;
			break;
		}
		if (i == 0 || str[i] == ' ')
			cnt++;
		i++;
	}
	printf("%d", cnt);
	return 0;
}
