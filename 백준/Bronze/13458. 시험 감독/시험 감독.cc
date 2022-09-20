#include <iostream>
#include <vector>

using namespace std;
/*
 * 0. 시험장의 수, 응시자의 수가 최대. B, C 최소
 * 1, 총 감독관은 반드시 1명
 * 2. 따라서 부감독관이 필요 없는 경우 발생
 * 3. 남은 응시자 수가 c로 나누어 떨어지지 않는 경우
 * */


int main() {
    int n, b, c;
    cin >> n;
    vector<int> arr(n, 0);
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    cin >> b >> c;

    long long answer = n; //주의

    for (int i = 0; i < n; i++) {
        int count = arr[i] - b;
        if (count <= 0) {
            continue;
        }
        answer += count / c; // 남은 인원수에 맞춰 부감독관 배치
        if (count % c > 0) {
            answer++;
        }
    }
    cout << answer;
    return 0;
}