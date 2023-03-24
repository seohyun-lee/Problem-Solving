#include <iostream>
#include <vector>

using namespace std;

int countCoin(int n, int k, vector<int>& coin) {
	int count = 0;
	int idx = n - 1;
	while (k) {
		count += k / coin[idx];
		k %= coin[idx];
		idx--;
	}
	return count;
}

int main()
{
	int n, k;
	cin >> n >> k;
	vector<int> coin(n, 0);
	for (int i = 0; i < n; i++) {
		cin >> coin[i];
	}
	cout << countCoin(n, k, coin);
	return 0;
}