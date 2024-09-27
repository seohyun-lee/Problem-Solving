#include <iostream>
#include <vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// N: 수열의 개수. M: 나누어떨어져야 하는 수. S: 합 벡터. C: 같은 나머지를 가지는 인덱스를 카운트하는 벡터.
	int N, M;
	cin >> N >> M;
	vector<long long> S(N, 0);
	vector<long long> C(M, 0); // 나머지 저장될 벡터가 따로 필요함
	long long answer = 0;
	cin >> S[0];

	for (int i = 1; i < N; i++) {
		long long temp = 0;
		cin >> temp;
		S[i] = S[i - 1] + temp;
	}
	for (int i = 0; i < N; i++) {
		long long remainder = S[i] % M; // 합 배열을 M으로 나눈 나머지 값
		if (remainder == 0) {
			answer++;
		}
		C[remainder]++;
	}
	for (int i = 0; i < M; i++) {
		// 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 정답에 더하기
		long long tmp = C[i];
		answer += tmp * (tmp - 1) / 2;
	}
	cout << answer;
}