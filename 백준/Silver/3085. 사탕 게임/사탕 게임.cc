#include <iostream>
#include <algorithm>
using namespace std;

int n;
char a[50][50];
int ans = 1;

void check(){
	int max_cnt = 1;
	for (int i = 0; i < n; i++) {
		int cnt = 1;
		for (int j = 0; j < n-1; j++) {
			if (a[i][j] == a[i][j + 1]) {
				cnt++;
				if (cnt > max_cnt) {
					max_cnt = cnt;
				}
			}
			else {
				cnt = 1;
			}
		}
	}

	for (int j = 0; j < n; j++) {
		int cnt = 1;
		for (int i = 0; i < n-1; i++) {
			if (a[i][j] == a[i + 1][j]) {
				cnt++;
				if (cnt > max_cnt) {
					max_cnt = cnt;
				}
			}
			else {
				cnt = 1;
			}
		}
	}

	if (max_cnt > ans) {
		ans = max_cnt;
	}
}

int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> a[i][j];
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if ((i != n - 1) && (a[i][j] != a[i + 1][j])) {
				swap(a[i][j], a[i + 1][j]);
				check();
				swap(a[i][j], a[i + 1][j]);
			}
			if ((j != n - 1) && (a[i][j] != a[i][j + 1])) {
				swap(a[i][j], a[i][j + 1]);
				check();
				swap(a[i][j], a[i][j + 1]);
			}
		}
	}
	cout << ans;
}