#include <iostream>
#include <deque>

using namespace std;
int n;
deque<int> dq(n);

void rotate(int k){
	for(int i=1; i<k; i++){
		dq.push_back(dq.front());
		dq.pop_front();
	}
	cout<<dq.front();
	dq.pop_front();
}

int main(){
	int k;
	cin >> n >> k;
	for(int i=1; i<=n; i++){
		dq.push_back(i);
	}
	cout<<'<';
	while(n--){
		rotate(k);
		if(dq.size()!=0){
			cout<<", ";
		}
	}
	cout<<'>';
}