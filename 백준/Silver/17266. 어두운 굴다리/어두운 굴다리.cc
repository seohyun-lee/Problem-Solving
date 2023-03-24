#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int binarySearch(int n, int m, vector<int>& v) {
	int start = 0;
	int end = n;
	while (start <= end) {
		int mid = (start + end) / 2;
		bool flag = 0;

		if (v[0] > mid || n - v[m-1] > mid) {
			flag = 1;
		}
		for(int i = 0; i < m - 1; i++){
			if (v[i + 1] - v[i] > mid * 2) {
				flag = 1;
				break;
			}
		}

		if (flag) {
			start = mid + 1;
		}
		else {
			end = mid - 1;
		}
	}
	return start;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m;
	cin >> n >> m;
	vector<int> v;
	for (int i = 0; i < m; i++) {
		int x;
		cin >> x;
		v.push_back(x);
	}
	sort(v.begin(), v.end());
	cout << binarySearch(n, m, v);
}