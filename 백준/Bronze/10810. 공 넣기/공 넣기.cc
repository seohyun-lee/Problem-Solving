#include <iostream>
using namespace std;

int main()
{
    int n, m;
    int i, j, k;
    cin >> n >> m;
    int* arr = new int[n];
    for(int a=0; a<m; a++) {
        cin >> i >> j >> k;
        for(int b=i-1; b<j;b++) {
            arr[b]=k;
        }
    }
    for(int a=0; a<n; a++) {
        cout << arr[a];
        if (a != n - 1) cout << " ";
    }
    
    return 0;
}