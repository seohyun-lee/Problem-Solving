#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    
    int p[9];
    int sum = -100;
    int flag = 0;
    for (int i=0; i<9; i++){
        cin >> p[i];
        sum += p[i];
    }
    sort(p, p+9);
    for (int i=0; i<9; i++) {
        for (int j=i+1; j<9; j++) {
            if (flag == 0 && (p[i]+p[j]) == sum) {
                p[i] = 0;
                p[j] = 0;
                flag = 1;
                break;
            }
        }
        if (p[i] != 0) {
            cout << p[i] << "\n";
        }
    }
}