#include <iostream>
#include <vector>

using namespace std;
const int SIZE = 8;

int n, m;
vector<int> num(SIZE);
vector<bool> check(SIZE);

void backtracking(int cnt, int start) {
	if (cnt == m) {
		for (int i = 0; i < cnt; i++) {
			cout << num[i] << ' ';
		}
		cout << '\n';
		return;
	}
	for (int i = start; i <= n; i++) {
		if (!check[i]) {
			num[cnt] = i;
			check[i] = true;
			backtracking(cnt + 1, i + 1);
			check[i] = false;
		}
	}
}
int main() {
	cin >> n >> m;
	backtracking(0, 1);
	return 0;
}