#include <iostream>
#include <map>
#include <vector>
using namespace std;

//추월을 한 차가 몇개인지 구하는 함수
int jumpCar(int n, vector<string>& out_car, map<string, int>& m) {
	int ans = 0; //몇개의 차가 추월?
	for (int i = 0; i < n; i++) { //나온 차 순서대로 검사한다
		for (int j = i + 1; j < n; j++) { //내 뒤의 차들의 인덱스가 나보다 작았다면
			if (m[out_car[i]] > m[out_car[j]]){ //(먼저 들어온 차였다면 추월)
				ans++;
				break; //추월을 한 차 갯수만 알면 됨
			}
		}
	}
	return ans;
}

int main() {
	int n;
	string car;
	map<string, int> m; //value는 처음에 들어온 순서
	cin >> n;
	vector<string> out_car(n, " ");
	for (int i = 1; i <= n; i++) {
		cin >> car;
		m[car] = i;
	}
	for (int i = 0; i < n; i++) {
		cin >> out_car[i]; //[i]가 곧 나온 순서이므로 이름만 필요함
	}
	cout << jumpCar(n, out_car, m);
	return 0;
}