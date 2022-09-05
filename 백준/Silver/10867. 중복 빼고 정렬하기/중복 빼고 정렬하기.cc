#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main() {
	int N;
	cin >> N;
	vector<int> arr;
	for (int i = 0; i < N; i++) {
		int a;
		bool overlap = false;
		cin >> a;
		if (i == 0) {
			arr.push_back(a);
			continue;
		}
		for (int j = 0; j < arr.size(); j++) {
			if (a == arr[j]) {
				overlap = true;
				break;
			}
		}
		if (overlap == false) {
			arr.push_back(a);
		}
	}
	sort(arr.begin(), arr.end());
	for (int i = 0; i < arr.size(); i++) {
		cout << arr[i] << " ";
	}
}
