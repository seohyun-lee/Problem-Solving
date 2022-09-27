#include <iostream>
#include <algorithm>

using namespace std;

struct mask {
	int num;
	int size;
};

mask m[10];
int newest = 0; //1~10까지 가능함

void func(string s, int cnt) {
	for (int i = s.length()-1; i >=0; i--) {
		bool check = false;
		for (int j = 0; j < newest; j++) {
			if (m[j].num == s[i]) {
				check = true;
				m[j].size += cnt;
				break;
			}
		}
		if (!check) {
			m[newest].num = s[i];
			m[newest].size = cnt;
			newest++;
			if (newest > 10) {
				cout << "NO";
				exit(0);
			}
		}
		cnt *= 10;
	}
}

bool check[10];

void backtracking(int cnt) {
	if (cnt == newest) {
		int result = 0;
		for (int i = 0; i < newest; i++) {
			result += m[i].size * m[i].num;
		}
		if (result == 0) {
			cout << "YES" << '\n';
			exit(0);
		}
		return;
	}

	for (int i = 0; i < 10; i++) {
		if (!check[i]) {
			m[cnt].num = i;
			check[i] = true;
			backtracking(cnt + 1);
			check[i] = false;
		}
	}
}

int main() {
	string s;
	for (int i = 0; i < 2; i++) {
		cin >> s;
		func(s, 1);
	}

	cin >> s;
	func(s, -1);

	backtracking(0);
	cout << "NO";
	return 0;
}