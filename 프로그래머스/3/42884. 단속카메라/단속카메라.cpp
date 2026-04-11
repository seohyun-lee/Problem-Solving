#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> routes) {
    // 2차원 벡터 정렬하려면 람다식이 필요하다
    sort(routes.begin(), routes.end(), [](vector<int>& a, vector<int>& b){
        return a[1]<b[1];
    });
    int cnt=0; 
    vector<int> curr={-1000000, -1000000};
    int c=0;
    for(vector<int> r : routes){
        if(curr[1]<r[0]) {
            curr={r[0],r[1]};
            cnt++;
        } else {
            curr[0]=r[0];
        }
    }
    return cnt;
}