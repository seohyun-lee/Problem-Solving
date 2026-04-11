#include <string>
#include <vector>
#include <climits>
using namespace std;

extern int excavate(int);

int n;
vector<int> dep;
vector<vector<int>> memo;
vector<vector<int>> memoIdx;

int minCost(int left, int right) {
    if (left > right) return 0;
    if (left == right) {
        memoIdx[left][right] = left;
        return dep[left-1];
    }
    if (memo[left][right] != -1) return memo[left][right];

    int res = INT_MAX;
    for (int k = left; k <= right; k++) {
        int worst = dep[k-1] + max(minCost(left, k-1), minCost(k+1, right));
        if (worst < res) {
            res = worst;
            memoIdx[left][right] = k;
        }
    }
    memo[left][right] = res;
    return memo[left][right];
}

int solution(vector<int> depth, int money) {
    n = depth.size();
    dep = depth;
    memo.assign(n+1, vector<int>(n+1, -1));
    memoIdx.assign(n+1, vector<int>(n+1, -1));

    minCost(1, n);
    int left = 1, right = n;
    while (left <= right) {
        int chosen = memoIdx[left][right];
        int result = excavate(chosen);

        if (result == 0) return chosen;
        if (result == -1) right = chosen - 1;
        if (result == 1) left = chosen + 1;
    }
    return -1;
}