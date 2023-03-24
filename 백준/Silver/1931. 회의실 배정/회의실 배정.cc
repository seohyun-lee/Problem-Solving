#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

typedef pair<int, int> ci;

int getMaxCount(int n, vector<ci> &meetings) {
	int count = 0;
	int prev_end = 0;
	for (int i = 0; i < n; i++) {
		int end = meetings[i].first;
		int start = meetings[i].second;
		if (start >= prev_end) {
			count++;
			prev_end = end;
		}
	}
	return count;
}

int main() {
	int n;
	cin >> n;
	vector<ci> meetings(n, { 0, 0 });

	for (int i = 0; i < n; i++) {
		cin >> meetings[i].second >> meetings[i].first;
	}
	sort(meetings.begin(), meetings.end());
	cout << getMaxCount(n, meetings);
	return 0;
}