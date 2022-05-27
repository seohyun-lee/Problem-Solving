#include<stdio.h>
int main()
{
	char a[101];
	int cnt=1, i=0;
	while(1){
		scanf("%c", &a[i]);
		if (a[i] == '\n')
			break;
		i++;
	}
	for (int j = 1; j < i; j++)	{
		if (a[j] == '=')
		{
			if (a[j - 1] == 'z' && a[j - 2] == 'd')
				cnt -= 2;
			else if (a[j-1]=='c'|| a[j - 1] == 's'|| a[j - 1] == 'z')
				cnt--;
		}
		else if (a[j] == '-')
		{
			if (a[j - 1] == 'c' || a[j - 1] == 'd')
				cnt--;
		}
		else if (a[j] == 'j')
		{
			if (a[j - 1] == 'l' || a[j - 1] == 'n')
				cnt--;
		}
		cnt++;
	}
	printf("%d", cnt);
}