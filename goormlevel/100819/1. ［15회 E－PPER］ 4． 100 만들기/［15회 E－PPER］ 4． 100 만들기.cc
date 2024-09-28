//프로그래머스에서는 main함수 및 입출력문이 필요하지 않습니다. 대신 solution함수만 작성하면 됩니다.
#include <iostream>
#include <vector>
using namespace std;

// 정수 배열 numbers 의 길이는 9 입니다.
vector<int> solution(vector<int> numbers) {
	int sum = 0;
	int arr[9][9] = {0,};
	
	int i,j;
	
	for(i=0;i<9;i++) {
		sum += numbers[i];
		for(j=0;j<9;j++) {
			arr[i][j] = numbers[i] + numbers[j];
		}
	}
	
	bool flag = false;
	for(i=0;i<9;i++) {
		for (j=i;j<9;j++) {
			if (sum - arr[i][j] == 100) {
				flag = true;
				// cout << "here" << "i" << i << "j" << j << "\n";
				break;
			}
		}
		if (flag == true)
			break;
	}
	
	vector<int> answer;
	for(int k=0;k<9;k++) {
		if (k != i && k != j)
			answer.push_back(numbers[k]);
	}
	return answer;
}

int main() {
	vector<int> numbers;
	
	for (int i = 0; i < 9; i++) {
		int temp;
		cin >> temp;
		numbers.push_back(temp);
	}
	
	vector<int> r = solution(numbers);
	for (int i = 0; i < 7; i++) {
		cout << r[i] << " ";
	}
}
