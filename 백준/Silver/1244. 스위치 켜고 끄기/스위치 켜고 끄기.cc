#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m;
	cin >> n;
	bool arr[100];
	for (int i = 0; i < n; i++) {
		bool b;
		cin >> b;
		arr[i] = b;
	}
	cin >> m;
	while (m--) {
		int gender, num;
		cin >> gender >> num;
		if (gender == 1) {
			for (int i = num-1; i < n; i += num) {
				arr[i] = 1 - arr[i];
			}
		}
		else {
			num--;
			arr[num] = 1 - arr[num];
			for (int i = 1; i <= num; i++) {
				if (num + i > n - 1) {
					break;
				}
				if (arr[num - i] == arr[num + i]) {
					arr[num - i] = 1 - arr[num - i];
					arr[num + i] = 1 - arr[num + i];
				}
				else
					break;
			}
		}
	}
	for (int i = 0; i < n; i++) {
		cout << arr[i];
		if ((i + 1) % 20 == 0) {
			cout << '\n';
		}
		else {
			cout << " ";
		}
	}
}