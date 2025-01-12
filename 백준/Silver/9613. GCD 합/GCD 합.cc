#include <bits/stdc++.h>
using namespace std;

int gcd(int a, int b) {
    if (a % b == 0) {
        return b;
    } else {
        return gcd(b, a % b);
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int t;
    cin >> t;
    while (t-- > 0) {
        int n;
        long long sum=0;
        cin >> n;
        vector<int> v(n);
        
        for (int i=0; i<n; i++) {
            cin >> v[i];
        }
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (v[i] > v[j])
                    sum += gcd(v[i], v[j]);
                else 
                    sum += gcd(v[j], v[i]);
            }
        }
        cout << sum << "\n";
    }
}