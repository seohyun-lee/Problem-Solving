#include <iostream>
#include <vector>
using namespace std;

struct info {
	int w, v;
};

int knapsack2(int n, int k, vector<info>& product) {
	vector<vector<int>> dp(n + 1, vector<int>(k + 1, 0));
	
	for (int i = 1; i <= n; i++) {
		for (int j = 0; j < product[i].w; j++) {
			dp[i][j] = dp[i - 1][j];
		}
		for (int j = product[i].w; j <= k; j++) {
			dp[i][j] = max(dp[i - 1][j - product[i].w] + product[i].v, dp[i - 1][j]);
		}
	}
	return dp[n][k];
}

int main() {
	int n, k;
	cin >> n >> k;
	vector<info> product(n + 1, { 0, 0 });
	for (int i = 1; i <= n; i++) {
		cin >> product[i].w >> product[i].v;
	}
	cout << knapsack2(n, k, product);
	return 0;
}