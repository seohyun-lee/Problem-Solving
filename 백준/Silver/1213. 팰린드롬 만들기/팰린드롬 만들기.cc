#include <iostream>
#include <algorithm>
#include <string>

using namespace std;
int alpha[26];


int main() {
	string s;
	cin >> s;

	for (int i = 0; i<s.size(); i++) {
		int num = s[i] - 'A';
		alpha[num]++;
	}

	int cnt = 0;
	int mid = -1;

	for (int i = 0; i<26; i++) {
		if (alpha[i] > 0 && alpha[i] % 2 == 1) {
			mid = i;
			alpha[i]--;
			cnt++;
		}
	}

	if (cnt > 1) {
		cout<<"I'm Sorry Hansoo";
	}
	else {
		string ans = "";
		string temp = "";
		for (int i = 0; i < 26; i++) {
			if (alpha[i] > 0) {
				for (int j = 0; j < alpha[i] / 2; j++) {
					ans += i + 'A';
				}
			}
		}
		temp = ans;
		reverse(temp.begin(), temp.end());
		if (mid != -1) {
			ans += mid + 'A';
		}
		ans += temp;
		cout << ans << '\n';
	}
}