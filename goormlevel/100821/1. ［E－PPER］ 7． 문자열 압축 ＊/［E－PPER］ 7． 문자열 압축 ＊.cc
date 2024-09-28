//프로그래머스에서는 main함수 및 입출력문이 필요하지 않습니다. 대신 solution함수만 작성하면 됩니다.
#include <iostream>
#include <vector>

using namespace std;

int main() { 
	string str;
	cin >> str;
	
	string ans = "";
	
	if (str[0] == '1'){
		ans += '1';
	}
	int cont = 0;
	int i;
	for (i=0; i<str.length(); i++){
		if (i != 0 && str[i-1] != str[i]) {// i-1까지를 더함
			if (cont >= 26)
				ans += 'Z';
			else
				ans += 'A' + cont - 1;
			cont = 1;
		}
		else {
			cont++;
		}
	}
	
	// 마지막
	if (cont >= 26)
		ans += 'Z';
	else
		ans += 'A' + cont - 1;
	
	cout << ans;
}