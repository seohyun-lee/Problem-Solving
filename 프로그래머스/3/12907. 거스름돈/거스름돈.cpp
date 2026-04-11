#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int n, vector<int> money) {
    int answer = 0;
    vector<int> dp(n+1);
    dp[0] = 1;
    for(int i=0; i<money.size(); i++){ // 사용할 수 있는 동전을 하나씩 추가 (money[i]를 쓰는 경우)
        for(int j=money[i]; j<=n; j++){
            dp[j] += dp[j-money[i]]; // dp[j]: 지금까지 본 동전들만 써서 j원 만드는 경우의 수. money[i]원 썼으면 dp[0]원이 남게 되므로 더한다.
        }
    }
    return dp[n];
}