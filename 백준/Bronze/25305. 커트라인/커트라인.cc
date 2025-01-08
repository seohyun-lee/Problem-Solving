
#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n, k;
    cin >> n >> k;
    int a[1000];
    for (int i=0; i<n; i++){
        cin >> a[i];
    }
    sort(a, a+n);
    cout << a[n-k];
    return 0;
}