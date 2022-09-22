#include <iostream>
using namespace std;

int n;
int num[11] = {};
int oper[4];

int m = 1000000001;
int M = -1000000001;

void func(int result, int count) {
	if (count == n - 1) {
		if (m > result) {
			m = result;
		}
		if (M < result) {
			M = result;
		}
		return;
	}

	for (int i = 0; i < 4; i++) {
		if (oper[i] == 0) continue;
		oper[i]--;
		if (i == 0) {
			func(result + num[count + 1], count + 1);
		}
		else if (i == 1) {
			func(result - num[count + 1], count + 1);
		}
		else if (i == 2) {
			func(result * num[count + 1], count + 1);
		}
		else {
			func(result / num[count + 1], count + 1);
		}

		oper[i]++;
	}
}

int main() {
	
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> num[i];
	}
	for (int i = 0; i < 4; i++) {
		cin >> oper[i];
	}
	func(num[0], 0);
	cout << M << '\n' << m << '\n';
}