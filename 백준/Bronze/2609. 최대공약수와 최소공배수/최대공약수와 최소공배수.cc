#include <iostream>
using namespace std;

int gcd(int a, int b) {
	for(int i=min(a,b);i>0;i--){
		if (a % i == 0 && b % i == 0) {
			return i;
		}
	}
	return 1;
}

int main() {
	int a, b;
	cin >> a >> b;
	int d = gcd(a, b);
	cout << d << '\n' << a * b / d;
}