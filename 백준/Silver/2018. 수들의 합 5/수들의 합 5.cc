#include <iostream>
#include <vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;
	int count = 1;
	int start_index = 1;
	int end_index = 1;
	int sum = 1;

	while (end_index != N) { // 이때가 끝나는 시점
		if (sum < N) {
			end_index++;
			sum += end_index;
		}
		else if (sum > N) {
			sum -= start_index;
			start_index++;
		}
		else { // 답을 찾았을 때
			count++;
			end_index++;
			sum += end_index;
		}
	}
	cout << count << "\n";
}