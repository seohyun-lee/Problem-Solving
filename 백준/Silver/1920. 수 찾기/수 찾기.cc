#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool binarySearch(int start, int end, int target, vector<int> &v) {
	while (start <= end) {
		int mid = (start + end) / 2;

		if (v[mid] == target) {
			return true;
		}
		if (v[mid] < target) {
			start = mid + 1;
		}
		else {
			end = mid - 1;
		}
	}
	return false;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m;
	cin >> n;
	vector<int> v;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}
	sort(v.begin(), v.end());
	cin >> m;
	while(m--){
		int num;
		cin >> num;
		cout << binarySearch(0, n-1, num, v) << '\n';
	}
}