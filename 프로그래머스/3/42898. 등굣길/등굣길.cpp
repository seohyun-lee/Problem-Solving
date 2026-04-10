#include <string>
#include <iostream>
#include <vector>

using namespace std;

int board[101][101]; // 가짓수


// 오, 아 로만 움직임. 이동경로 가짓수 누적 DP
int solution(int m, int n, vector<vector<int>> puddles) {
    int answer = 0;
    for(int i=0; i<puddles.size(); i++){
        board[puddles[i][0]][puddles[i][1]] = -1;
    }
    board[1][1]=1;
    for(int i=1; i<=m; i++){
        for(int j=1; j<=n; j++){
            if(board[i][j]==-1) continue;
            if(board[i-1][j]!=-1) {
                board[i][j] += board[i-1][j];
            }
            if(board[i][j-1]!=-1) {
                board[i][j] += board[i][j-1];
            }
            board[i][j] %=1000000007;
        }
    }
    return board[m][n];
}