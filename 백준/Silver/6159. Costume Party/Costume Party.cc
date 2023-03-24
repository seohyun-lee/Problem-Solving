#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> v;
int pairCount(int n, int s) {
	int cnt = 0;
	int first = 0, second = 1;
	while (1) {
		if (v[first] + v[second] <= s) {
			cnt++;
		}
		else if (second - first == 1)
			break;
		if (second == n - 1) {
			if (first == n - 2)
				break;
			first++;
			second = first + 1;
		}
		else {
			second++;
		}
	}
	return cnt;
}
int main() {
	int n, s;
	cin >> n >> s;
	for (int i = 0; i < n; i++) {
		int l;
		cin >> l;
		v.push_back(l);
	}
	sort(v.begin(), v.end());
	cout<< pairCount(n, s);
}