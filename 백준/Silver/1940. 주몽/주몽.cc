#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 특징: 정렬을 해야 함, 2개로 M을 만들어야 함. 가운데로 모아지는 느낌
	/*
	* A[i]+A[j] == M이면 양쪽 포인터를 모두 이동시키고 count를 증가.
	* 번호의 합이 M보다 크면 큰 번호 index인 j를 1 감소시키고 번호의 합이 M보다 작으면 작은 번호 index를 올림
	*
	*/

	int N, M;
	cin >> N >> M;
	vector<int> A(N, 0);

	for (int i = 0; i < N; i++) {
		cin >> A[i];
	}
	sort(A.begin(), A.end());

	int count = 0;
	int i = 0;
	int j = N - 1;

	while (i < j) {
		if (A[i] + A[j] < M) {
			i++;
		}
		else if (A[i] + A[j] > M) {
			j--;
		}
		else {
			count++;
			i++;
			j--;
		}
	}
	cout << count;
}