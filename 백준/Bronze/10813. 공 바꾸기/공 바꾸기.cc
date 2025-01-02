#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int N, M;
    cin >> N >> M;
    
    vector<int> v(N);
    for (int p=0; p<N; p++) {
        v[p] = p + 1;
    }
    for (int p=0; p<M; p++) {
        int i, j;
        cin >> i >> j;
        swap(v[i-1], v[j-1]);
    }
    for (int p=0; p<N; p++) {
        cout << v[p] << " ";
    }
    cout << endl;
}