#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	vector<int> v;
	int sum, cnt=0;

	for(int i=0;i<10;i++){
		int num;
		char c;
		cin >> num;
		v.push_back(num);
		cin.get(c); //공백 또는 '\n' 입력받기
		if (c == '\n')
			break;
	}
	cin >> sum;
	sort(v.begin(), v.end());

	map<pair<int, int>, bool> visited;
	for (int i = 0; i < v.size();i++) {
		for (int j = i + 1; j < v.size(); j++) {
			if (v[i] + v[j] == sum && !visited.count({ v[i], v[j] })) { //map의 .count() 함수를 통해 키값이 있는지 확인
				cout << v[i] << " " << v[j] << '\n';
				visited[{v[i], v[j]}] = true;
				cnt++;
			}
		}
	}
	cout << cnt;
	return 0;
}