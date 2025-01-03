#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    vector<int> v(3);
    for (int i=0; i<3; i++) {
        int x;
        cin >> x;
        v[i] = x;
    }
    sort(v.begin(), v.end());
    for (int i=0; i<3; i++) {
        cout << v[i] << " ";
    }
}
