#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int map[10][10];
bool visited[10][10];
int minprice = 20000;
int dy[5] = { 0, 0, 1, -1, 0 };
int dx[5] = { -1, 1, 0, 0, 0 };

void dfs(int n, int count, int price) {
    if (count == 3) {
        minprice = min(minprice, price);
        return;
    }
    for (int i = 1; i < n - 1; i++) {
        for (int j = 1; j < n - 1; j++) {
            int tempprice = 0;
            int index;
            for (index = 0; index < 5; index++) {
                if (visited[i + dy[index]][j + dx[index]])
                    break;
                else
                    tempprice += map[i + dy[index]][j + dx[index]];
            }
            if (index == 5) {
                for (int k = 0; k < 5; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    visited[ny][nx] = true;
                }
                dfs(n, count + 1, price + tempprice);
                for (int k = 0; k < 5; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    visited[ny][nx] = false;
                }
            }
        }
    }
}

int main()
{
    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> map[i][j];
        }
    }
    dfs(n, 0, 0);
    cout << minprice;
    return 0;
}