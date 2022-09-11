#include<iostream>
#include<algorithm>
using namespace std;
int main()
{
	int N, MIN = 0;
	cin >> N;
	int* arr_A = new int[N];
	int* arr_B = new int[N];
	for (int i = 0; i < N; i++) {
		cin >> arr_A[i];
	}
	for (int i = 0; i < N; i++) {
		cin >> arr_B[i];
	}
	sort(arr_A, arr_A + N);
	sort(arr_B, arr_B + N);
	for (int i = 0; i < N; i++) {
		MIN += arr_A[i] * arr_B[N - 1 - i];
	}
	cout << MIN;
	delete[] arr_A;
	delete[] arr_B;
	return 0;
}