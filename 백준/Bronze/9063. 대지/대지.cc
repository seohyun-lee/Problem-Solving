
#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    int xmin=10000, ymin=10000;
    int xmax=-10000, ymax=-10000;
    while (n--) {
        int x, y;
        cin >> x >> y;
        xmin = min(x, xmin);
        ymin = min(y, ymin);
        xmax = max(x, xmax);
        ymax = max(y, ymax);
    }
    cout << (ymax-ymin)*(xmax-xmin);
}