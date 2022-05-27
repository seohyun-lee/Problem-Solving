int main()
{
	char pw='s', w;
	int cnt = 0;
	int i = 0;
	while (1) {
		scanf("%c", &w);
		if (i == 0 && w == ' ')
			continue;
		if (w == '\n')
		{
			if (pw == ' ')
				cnt--;
			break;
		}
		if (i == 0 || w == ' ')
			cnt++;
		i++;
		pw = w;
	}
	printf("%d", cnt);
	return 0;
}