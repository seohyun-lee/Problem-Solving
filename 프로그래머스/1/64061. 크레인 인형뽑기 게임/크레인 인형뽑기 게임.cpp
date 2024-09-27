#include <string>
#include <vector>
#include <stack>

using namespace std;

int solution(vector<vector<int>> board, vector<int> moves) {
    int answer = 0;
    stack<int> s;
    
    int n = board[0].size();
    int len = moves.size();
    
    for (int i=0; i<len; i++) {
        int x = moves[i] - 1;
        for (int j=0; j<n; j++) {
            if (board[j][x] == 0) {
                continue;
            }
            else {
                if (!s.empty() && board[j][x] == s.top()) {
                    s.pop();
                    answer += 2;
                } else {
                    s.push(board[j][x]);
                }
                board[j][x] = 0;
                break;
            }
        }
    }
    return answer;
}