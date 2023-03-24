#include <iostream>
using namespace std;

struct base {
	int hund;
	int ten;
	int one;
	int strike;
	int ball;
};

struct base arr[100];

int numCheck(int N) {
	int ans = 0;
	for(int i = 123; i <= 987; i++){
		int h = i / 100;
		int t = i % 100 / 10;
		int o = i % 10;
		if ((h == t || t == o) || h == o)
			continue;
		if ((h == 0 || t == 0) || o == 0)
			continue;

		int ncheck = 0;
		for (int j = 0; j < N; j++) {
			int stk_cnt = 0, bal_cnt = 0;

			if (h == arr[j].hund) {
				stk_cnt++;
			}
			if (t == arr[j].ten) {
				stk_cnt++;
			}
			if (o == arr[j].one) {
				stk_cnt++;
			}

			if (h == arr[j].ten || h == arr[j].one) {
				bal_cnt++;
			}
			if (t == arr[j].hund || t == arr[j].one) {
				bal_cnt++;
			}
			if (o == arr[j].hund || o == arr[j].ten) {
				bal_cnt++;
			}

			if (stk_cnt == arr[j].strike && bal_cnt == arr[j].ball) {
				ncheck++;
			}
		}

		if (ncheck==N) {
			ans++;
		}
	}
	return ans;
}
int main() {
	int N;
	cin >> N;
	for (int i = 0; i < N; i++) {
		int qnum, strike, ball;
		cin >> qnum >> strike >> ball;
		arr[i].hund = qnum/100;
		arr[i].ten = qnum%100/10;
		arr[i].one = qnum%10;
		arr[i].strike = strike;
		arr[i].ball = ball;
	}
	cout << numCheck(N);
}