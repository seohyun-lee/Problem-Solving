#include <iostream>
#include <set>
using namespace std;
int main() {
	set<string> s;
	int n;
	cin >> n;
	for(int i=0;i<n;i++) {
		string name, state;
		cin >> name >> state;
		if (state == "enter")
			s.insert(name);
		else
			s.erase(name);
	}
	for (auto riter = s.rbegin(); riter != s.rend(); riter++) {
		cout << *riter << '\n';
	}
}