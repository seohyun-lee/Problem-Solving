#include <iostream>
#include <algorithm>

using namespace std;

int n, m, arr[8], seq[8];
bool check[8];

void backtracking(int cnt) {
	if (cnt == m) {
		for (int i = 0; i < m; i++) {
			cout << seq[i] << ' ';
		}
		cout << '\n';
		return;
	}
	
	int bfnum = 0;
	for (int i = 0; i < n; i++) {
		if (!check[i] && arr[i] != bfnum) {
			seq[cnt] = arr[i];
			bfnum = seq[cnt];
			check[i] = true;
			backtracking(cnt + 1);
			check[i] = false;
		}
	}
}

int main() {
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	sort(arr, arr + n);
	backtracking(0);
}