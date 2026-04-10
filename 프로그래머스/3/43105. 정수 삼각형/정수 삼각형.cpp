#include <string>
#include <vector>
#include <iostream>

using namespace std;

int arr[501][501];

int solution(vector<vector<int>> triangle) {
    int answer = 0;
    // 그리디가 아니다... 직각삼각형처럼 생각. 
    int n=triangle.size();
    for(int y=n-1; y>=0; y--){
        for(int x=0; x<=y; x++){
            int under=0;
            if(y<n-1) {
                under = max(arr[y+1][x], arr[y+1][x+1]);
            }
            arr[y][x] = under + triangle.at(y).at(x);
        }
    }
    return arr[0][0];
}