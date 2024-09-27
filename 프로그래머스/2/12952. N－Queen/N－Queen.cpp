#include <string>
#include <vector>
#include <iostream>

using namespace std;

bool available(vector<vector<int>> arr, int n, int idx, int k) {
    for(int i=1;i<=idx;i++) {
        if (arr[idx-i][k] != 0)
            return false;
        if (k-i >= 0 && arr[idx-i][k-i] != 0)
            return false;
        if (k+i < n && arr[idx-i][k+i] != 0)
            return false;
    }
    return true;
}

void func(vector<vector<int>> arr, int n, int idx, int *cnt) {
    if (n == idx) {
        (*cnt)++;
        return;
    }
    for (int k=0; k<n; k++) {
        if (available(arr, n, idx, k)) {
            arr[idx][k] = 1;
            func(arr, n, idx+1, cnt);
            arr[idx][k] = 0;
        }
    }
}

int solution(int n) {
    int cnt = 0;
    vector<vector<int>> arr(n, vector<int>(n,0));
    func(arr, n, 0, &cnt);
    return cnt;
}