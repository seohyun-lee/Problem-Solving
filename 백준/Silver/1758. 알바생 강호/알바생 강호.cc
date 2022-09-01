#include<iostream>
#include<algorithm>
using namespace std;
int main()
{
	int N;
	long long int MAX=0;
	cin >> N;
	int* arr = new int[N];
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}
	sort(arr, arr + N);
	for (int i = 0; i < N; i++) {
		arr[i] = arr[i] - (N-1-i);
		if (arr[i] > 0)
			MAX += arr[i];
	}
	cout << MAX;
	delete[] arr;
	return 0;
}