#include <iostream>

using namespace std;

int main() {
	ios::ios_base::sync_with_stdio(false);
	cin.tie(0);
	int n, x;
	string cmd;
	bool arr[20] = {};
	cin >> n;
	while (n--) {
		cin >> cmd;
		if (cmd == "all") {
			for (int i = 0; i < 20; i++)
				arr[i] = 1;
		}
		else if (cmd == "empty") {
			for (int i = 0; i < 20; i++)
				arr[i] = 0;
		}
		else
			cin >> x;
		if (cmd == "add") {
			arr[x - 1] = 1;
		}
		if (cmd == "remove") {
			arr[x - 1] = 0;
		}
		if (cmd == "check") {
			if(arr[x - 1] == 1)
				cout << 1 <<"\n";
			else
				cout << 0 << "\n";
		}
		if (cmd == "toggle") {
			if (arr[x - 1] == 1)
				arr[x - 1] = 0;
			else
				arr[x - 1] = 1;
		}
	}
	return 0;
}