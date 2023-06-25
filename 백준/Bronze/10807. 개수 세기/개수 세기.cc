#include <iostream>
using namespace std;

int arr[201];

int main() {
	int n, v;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int t;
		cin >> t;
		arr[t+100]++;
	}
	cin >> v;
	cout << arr[v+100];
}