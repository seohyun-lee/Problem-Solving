#include <iostream>

using namespace std;

int charge(int h, int m, int d) {
	int amin = 60 - m;
	int bmin = d - amin;
	if (h == 6){
		if (m + d >= 60) {
			return 5 * amin + 10 * bmin;
		}
	}
	else if (h == 18) {
		if (m + d >= 60) {
			return 10 * amin + 5 * bmin;
		}
	}
	if (h >= 7 && h < 19) {
		return d * 10;
	}
	return d * 5;
}

int main() {
	int n;
	cin >> n;
	int total = 0;
	while (n--) {
		int h, m, d;
		scanf("%2d:%2d %d", &h, &m, &d); //':'와 정수 두자리를 입력받으려고 scanf 사용함
		total += charge(h, m, d);
	}
	cout << total << '\n';
}