#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int N;
    int i;
    cin >> N;

    vector<int> v(N);
    for (i = 0; i < N; ++i) {
        cin >> v[i];
    }
    sort(v.begin(), v.end());
    cout << v[(N - 1) / 2];
    return 0;
}