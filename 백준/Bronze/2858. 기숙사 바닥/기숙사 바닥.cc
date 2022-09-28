#include <iostream>
using namespace std;

int main() {
	int r, b, l, w;
	cin >> r >> b;
	int siz = r + b;
	for (w = 3; w < siz / 2; w++) {
		if(siz % w == 0){
			l = siz / w;
			if (r == (l + w - 2) * 2) {
				break;
			}
		}
	}
	cout << l << " " << w;
}