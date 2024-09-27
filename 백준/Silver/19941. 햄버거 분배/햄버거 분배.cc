#include <iostream>
#include <vector>
using namespace std;

bool canEat(int start, int end, string& str) {
	for (int i = start; i <= end; i++) {
		if (i >= 0 && i < str.length() && str[i] == 'H') {
			str[i] = 'E';
			return true;
		}
	}
	return false;
}

int solution(int N, int K, string& str) {
	int ans = 0;

	for (int i = 0; i < str.length(); i++) {
		if (str[i] == 'P') { // 사람인 경우
			if (canEat(i - K, i - 1, str)) { // 왼쪽
				ans++;
			}
			else if (canEat(i + 1, i + K, str)) { // 오른쪽
				ans++;
			}
		}
	}
	return ans;
}


int main() {
	int N, K;
	string str;
	cin >> N >> K >> str;
	cout << solution(N, K, str);
	return 0;
}