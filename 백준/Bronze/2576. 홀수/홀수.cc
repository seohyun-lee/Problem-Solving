#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    
    int oddSum = 0;
    int oddMin = 100;
    int a;
    for (int i=0; i<7; i++) {
        cin >> a;
        if (a % 2 == 1) {
            oddSum += a;
            oddMin = min({a, oddMin});
        }
    }
    if (oddSum == 0)
        cout << "-1";
    else
        cout << oddSum << "\n" << oddMin;
}
