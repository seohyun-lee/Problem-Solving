#include <stdio.h>
int recur(int k, int n) {
	if (k == 0)
		return n;
	int value=0;
	for (int i = n;i > 0;i--)
		value += recur(k-1, i);
	return value;
}
int main() {
	int T;
	scanf("%d", &T);
	for (int i = 0; i < T; i++)
	{
		int k, n;
		int pplnum;
		scanf("%d%d", &k, &n);
		pplnum = recur(k, n);
		printf("%d\n", pplnum);
	}
}