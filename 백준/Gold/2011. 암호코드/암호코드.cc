#include <iostream>
#include <vector>

using namespace std;
const int MOD = 1e6;

int cntPassword(int n, string& s) {
	vector<int> dp(n + 1, 0);
	if (s[0] == '0') {
		return 0;
	}
	s = ' ' + s;

	dp[0] = dp[1] = 1;
	for (int i = 2; i <= n; i++) {
		if (s[i] == '0' && (s[i - 1] < '1' || s[i - 1] > '2')) {
			return 0;
		}
		if (s[i] != '0') { //한 글자 암호 해석 가능
			dp[i] += dp[i - 1];
		}
		if (s[i - 1] == '1' || (s[i - 1] == '2' && s[i] <= '6')) {
			dp[i] += dp[i - 2];
		}
		dp[i] %= MOD;
	}
	return dp[n];
}

int main() {
	string s;
	cin >> s;
	cout << cntPassword(s.length(), s);
	return 0;
}