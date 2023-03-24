#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int N;
	int time=0;
	cin >> N;
	int arr[1000];
	for (int i = 0; i < N; i++) {
		int a;
		cin >> arr[i];
	}
	sort(arr, arr + N);
	for (int i = 0; i < N; i++) {
		time += arr[i]*(N-i);
	}
	cout << time;
}