#include <iostream>
#include <vector>
using namespace std;

int main() {
	int n, k, it=0; //cnt 0~n-1
	cin >> n >> k;
	vector<char> wheel(n, '?');
	int arr[26] = {};

	for (int i = 0; i < k; i++) {
		int s;
		char c;
		cin >> s >> c;
		it = (it + s) % n;
		if (arr[c - 'A'] != 0 && arr[c - 'A'] != it) {
			cout << '!' << '\n';
			return 0;
		}
		else if (wheel[it] != '?' && wheel[it] != c) {
			cout << '!' << '\n';
			return 0;
		}

		if (wheel[it] == '?') {
			wheel[it] = c;
			arr[c - 'A'] = it;
		}
		else if (wheel[it] != c) {
			cout << '!' << '\n';
			return 0;
		}
	}
	for (int i = 0; i < n; i++) {
		cout << wheel[it];
		it--;
		if (it < 0) {
			it += n;
		}
	}
	cout << '\n';
	return 0;
}