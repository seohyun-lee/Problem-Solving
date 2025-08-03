#include <iostream>
#include <vector>
using namespace std;

int main()
{
    int n,m;
    cin >> n >> m;
    vector<vector<int>> A(n);
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            int k;
            cin >> k;
            A[i].push_back(k);
        }
    }
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            int k;
            cin >> k;
            A[i][j] = A[i][j] + k;
        }
    }
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            cout << A[i][j] << " ";
        }
        cout << "\n";
    }
    return 0;
}