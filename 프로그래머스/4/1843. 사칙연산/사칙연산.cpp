#include <vector>
#include <string>
#include <iostream>

using namespace std;

int solution(vector<string> arr)
{
    int max_dp[102][102] = {0,};
    int min_dp[102][102] = {0,};
    int numSize = arr.size()/2+1;
    
    // 자기자신 넣고 + 초기화
    for(int i=0; i<numSize; i++){
        for(int j=0; j<numSize; j++) {
            if(i==j){
                max_dp[i][j] = stoi(arr[i*2]);
                min_dp[i][j] = stoi(arr[i*2]);
            } else {
                max_dp[i][j] = -1000000000;
                min_dp[i][j] = 1000000000;
            }
        }
    }
    
    // DP 최댓값과 최소값을 입력해나가며 계산
    for(int idx=1; idx<numSize; idx++){
        for(int i=0; i<numSize-idx; i++) {
            int j=idx+i;
            
            for(int k=i; k<j; k++){
                if(arr[k*2+1] == "-") {
                    max_dp[i][j] = max(max_dp[i][j], max_dp[i][k] - min_dp[k+1][j]);
                    min_dp[i][j] = min(min_dp[i][j], min_dp[i][k] - max_dp[k+1][j]);
                }
                else if(arr[k * 2 + 1] == "+")
                {
                    max_dp[i][j] = max(max_dp[i][j], max_dp[i][k] + max_dp[k+1][j]);
                    min_dp[i][j] = min(min_dp[i][j], min_dp[i][k] + min_dp[k+1][j]);
                }
            }
        }
    }
    return max_dp[0][numSize-1];
}