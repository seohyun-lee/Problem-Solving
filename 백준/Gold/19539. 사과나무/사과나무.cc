#include <iostream>

using namespace std;

int main() {
	int n;
	int input;
	int sum = 0;
	int one = 0;
	int two = 0;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> input;
		sum += input;
		one += input % 2;
		two += input / 2;
	}
	if (sum % 3 || one > two) {
		cout << "NO";
	}
	else {
		cout << "YES";
	}
}