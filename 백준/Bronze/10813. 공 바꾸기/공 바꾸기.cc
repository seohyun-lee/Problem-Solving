#include <iostream>
#include <vector>
using namespace std;

int main() {
    int N, M;
    cin >> N >> M;

    vector<int> baskets(N);
    for (int i = 0; i < N; ++i) {
        baskets[i] = i + 1;
    }
    
    for (int k = 0; k < M; ++k) {
        int i, j;
        cin >> i >> j;
        swap(baskets[i - 1], baskets[j - 1]);
    }

    for (int i = 0; i < N; ++i) {
        cout << baskets[i] << " ";
    }
    cout << endl;

    return 0;
}
