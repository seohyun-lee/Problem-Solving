#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    
    int avg = 0, median = 0;
    int a[5];
    for (int i=0; i<5; i++) {
        cin >> a[i];
        avg += a[i];
    }
    sort(a, a+5);
    median = a[2];
    avg /= 5;
    cout << avg << "\n" << median;
}