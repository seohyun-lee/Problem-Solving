#include <iostream>
#include <vector>
#include <deque>
#include <map>

using namespace std;
typedef pair<int, int> ci;

int playGame(int n, vector<vector<int>>& board, map<int, char>& cmd) {
	int dr[4] = { 0, -1, 0, 1 };
	int dc[4] = { 1, 0, -1, 0 };

	deque<ci> snake;
	snake.push_front({ 0, 0 });
	board[0][0] = 1;

	int t = 0, head_dir = 0;
	while (true) {
		t++;

		int nr = snake.front().first + dr[head_dir];
		int nc = snake.front().second + dc[head_dir];

		if (nr < 0 || nr >= n || nc < 0 || nc >= n || board[nr][nc] == 1) {
			break;
		}
		if (board[nr][nc]!=2) {
			board[snake.back().first][snake.back().second] = 0;
			snake.pop_back();
		}
		snake.push_front({ nr, nc });
		board[nr][nc] = 1;

		if (cmd[t] == 'L') {
			head_dir = (head_dir + 1) % 4;
		} else if (cmd[t] == 'D') {
			head_dir = (head_dir + 3) % 4;
		}
	}
	return t;
}

int main() {
	int n, k, row, col, l, x;
	char c;
	cin >> n >> k;
	vector<vector<int>> board(n, vector<int>(n));
	for (int i = 0; i < k; i++) {
		cin >> row >> col;
		board[row - 1][col - 1] = 2;
	}
	cin >> l;
	map<int, char> cmd;
	for (int i = 0; i < l; i++) {
		cin >> x >> c;
		cmd[x] = c;
	}

	cout << playGame(n, board, cmd);
	return 0;
}