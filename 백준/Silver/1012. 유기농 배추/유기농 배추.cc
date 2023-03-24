#include <iostream>
#include <string.h>
using namespace std;

int arr[50][50];
int check[50][50];
int m, n;

void dfs(int r, int c) {
	check[r][c] = true;

	int dr[] = { -1, 1, 0, 0 };
	int dc[] = { 0, 0, -1, 1 };

	for (int i = 0; i < 4; i++) {
		int new_r = r + dr[i];
		int new_c = c + dc[i];
		if (new_r >= 0 && new_r < n && new_c >= 0 && new_c < m) {
			if ((arr[new_r][new_c] == 1) && !check[new_r][new_c]) {
				dfs(new_r, new_c);
			}
		}
		else continue;
	}
}

int main() {
	int t, k;
	cin >> t;
	while (t--) {
		cin >> m >> n >> k;
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			int x, y;
			cin >> x >> y;
			arr[y][x] = 1;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if ((arr[i][j] == 1) && !check[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		cout << cnt << '\n';
		memset(check, false, sizeof(check));
		memset(arr, 0, sizeof(arr));
	}
}